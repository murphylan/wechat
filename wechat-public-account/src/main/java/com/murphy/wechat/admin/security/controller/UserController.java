package com.murphy.wechat.admin.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.murphy.wechat.admin.security.entity.UserDO;
import com.murphy.wechat.admin.security.entity.UserPrincipal;

@Controller
public class UserController {

	@GetMapping({"/","index"})
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping(path = "/hello")
    public String hello(Model model, Authentication authentication) {
        UserDO user = ((UserPrincipal)authentication.getPrincipal()).getUser();
        model.addAttribute("email", user.getEmail());
 
        return "hello";
    }
	
}
