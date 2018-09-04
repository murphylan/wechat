package com.murphy.wechat.admin.business;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";


	@GetMapping("/testhelloword")
	@ResponseBody
	@Transactional(readOnly = true)
	public String helloWorld() {
		return message;
	}
	
	@GetMapping("/weui")
	public String demo() {
		return "/demo/weui";
	}
	
}
