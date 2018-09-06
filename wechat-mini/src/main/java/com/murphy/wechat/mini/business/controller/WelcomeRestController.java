package com.murphy.wechat.mini.business.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murphy.wechat.mini.security.entity.UserDO;

@RestController
public class WelcomeRestController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";


	@RequestMapping("/test")
	public String index() {
		return message;
	}


	@RequestMapping(value = "/getjson", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserDO getJson() throws IOException {
		UserDO user = new UserDO();
		user.setEmail("murphylan@hotmail.com");
		user.setUsername("murphy");
		user.setPassword("password");
		return user;
	}

}
