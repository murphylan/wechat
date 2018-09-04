package com.murphy.wechat.admin.security.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.murphy.wechat.admin.security.entity.UserDO;
import com.murphy.wechat.admin.security.entity.UserPrincipal;

@Controller
public class UserController {

	@GetMapping({"/","index"})
	public String index(Principal principal) {
		 return principal != null ? "demo/weui" : "hello";
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
