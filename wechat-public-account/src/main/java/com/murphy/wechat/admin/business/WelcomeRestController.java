package com.murphy.wechat.admin.business;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murphy.wechat.admin.security.entity.UserDO;

@RestController
public class WelcomeRestController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@GetMapping("/test")
	@Async
	public CompletableFuture<String> index() {
		return CompletableFuture.supplyAsync(() -> message);
	}

	@GetMapping(value = "/getjson", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public UserDO getJson() throws IOException {
		UserDO user = new UserDO();
		user.setEmail("murphylan@hotmail.com");
		user.setUsername("murphy");
		user.setPassword("password");
		return user;
	}

}
