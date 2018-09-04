package com.murphy.wechat.admin.wechat.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.murphy.wechat.admin.wechat.config.WechatMpProperties;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

/**
 * @author Murphy
 */
@RestController
@RequestMapping("/wechat/user")
public class WxUserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WxMpService wxService;

	@Autowired
	private WechatMpProperties properties;

	@GetMapping("/authorize")
	public String authorize(String state) {
		// 1.配置
		String url = properties.getHost() + "/userinfo";
		String redirectUrl = wxService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, state);

		logger.info("【微信网页授权】 获取code ， redirectUrl={}", redirectUrl);

		return "redirect:" + redirectUrl;
	}

	@GetMapping("/userinfo")
	public String userInfo(@RequestParam("code") String code, @RequestParam("state") String returnUrl) {
		WxMpOAuth2AccessToken oauth2getAccessToken = new WxMpOAuth2AccessToken();
		try {
			oauth2getAccessToken = wxService.oauth2getAccessToken(code);

		} catch (WxErrorException e) {
			logger.error("【微信网页授权】 {}", e);
		}

		String openId = oauth2getAccessToken.getOpenId();

		return "redirect:" + returnUrl + "?openid=" + openId;

	}

}
