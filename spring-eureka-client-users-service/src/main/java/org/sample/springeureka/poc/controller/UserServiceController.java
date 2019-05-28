package org.sample.springeureka.poc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sample.springeureka.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceController.class);
	private static Map<String, List<User>> loginUserDB = new HashMap<String, List<User>>();

	static {
		loginUserDB = new HashMap<String, List<User>>();

		// Admin User list compose
		List<User> userList  = new ArrayList<User>();
		User usertoAdd = new User("Admin", "Guest User One");
		userList.add(usertoAdd);
		usertoAdd = new User("AdminOne", "Guest User Two");
		userList.add(usertoAdd);

		loginUserDB.put("Admin", userList);

		// Non Admin User list compose
		userList = new ArrayList<User>();
		usertoAdd = new User("NonAdmin", "Guest User One");
		userList.add(usertoAdd);
		usertoAdd = new User("NonAdminOne", "Guest User Two");
		userList.add(usertoAdd);

		loginUserDB.put("NonAdmin", userList);

	}

	@RequestMapping(value = "/getUserDetailsForLogin/{privileged}", method = RequestMethod.GET)
	public List<User> getStudents(@PathVariable String privileged) {
		LOGGER.info("Getting Login User details for - {}", privileged);

		List<User> userList  = loginUserDB.get(privileged);
		if (userList == null) {
			userList = new ArrayList<User>();
			User user = new User("Not Found", "N/A");
			userList.add(user);
		}
		return userList;
	}
}
