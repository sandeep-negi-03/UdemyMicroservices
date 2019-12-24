package com.in28minutes.learning.jpa.jpain10steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserDAOService;

@Component
public class UserDaoServiceCommandlineRunner implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(UserDaoServiceCommandlineRunner.class);
	
	@Autowired
	private UserDAOService userDAOService; 
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		userDAOService.intsert(user);
		logger.info("New User is created : " + user);
	}

}
