package com.murphy.wechat.admin.init;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.murphy.wechat.admin.security.entity.UserDO;
import com.murphy.wechat.admin.security.repository.UserRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {
	private static final Logger LOG = LoggerFactory.getLogger(AppStartupRunner.class);

	public static int counter;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOG.info("Application started with option names : {}", args.getOptionNames());
		LOG.info("Increment counter");
		counter++;

		UserDO user = new UserDO();
		user.setEmail("murphylan@hotmail.com");
		user.setUsername("murphy");
		user.setPassword("password");

		ArrayList<String> roles = new ArrayList<>();
		roles.add("USER");
		user.setRoles(roles);
		
		userRepository.save(user);
		
		LOG.info("Init USER");
	}
}
