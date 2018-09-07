package com.murphy.wechat.admin.security.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.murphy.wechat.admin.security.entity.UserDO;
import com.murphy.wechat.admin.security.entity.UserPrincipal;
import com.murphy.wechat.admin.security.service.InternalUserDetailService;

@Controller
public class UserController {

	@Autowired
	private InternalUserDetailService userDetailsService;

	/**
	 * 判断是否登陆
	 * 
	 * principal.getName() 返回当前用户的username
	 * 
	 * @param principal
	 * @return
	 */
	@GetMapping({ "/", "index" })
	public String index(Principal principal) {
		return principal != null ? "demo/weui" : "hello";
	}

	@GetMapping("login")
	public String login() {
		return "login";
	}

	@GetMapping(path = "/hello")
	public String hello(Model model, Authentication authentication) {
		UserDO user = ((UserPrincipal) authentication.getPrincipal()).getUser();
		model.addAttribute("email", user.getEmail());
		return "hello";
	}

	/**
	 * 后端登陆
	 * 
	 * @param username
	 */
	@GetMapping("/loginbackend/{username}")
	public void loginbackend(@PathVariable("username") String username) {
		userDetailsService.login(username);
	}

	/***
	 * 通用的页面跳转方法
	 * 
	 * @param pagename
	 * @return
	 */
	@GetMapping("/page/{path}/{pagename}")
	public String page(@PathVariable("pagepath") String pagepath, @PathVariable("pagename") String pagename) {
		return "/" + pagepath + "/" + pagename;
	}

}
