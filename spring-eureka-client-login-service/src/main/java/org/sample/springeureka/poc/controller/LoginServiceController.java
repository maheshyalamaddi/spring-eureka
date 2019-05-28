package org.sample.springeureka.poc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceController.class);

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "/getLoginUserDetails/{privileged}", method = RequestMethod.GET)
	public String getStudents(@PathVariable String privileged) {
		System.out.println("Getting login User details for " + privileged);
		String response = restTemplate.exchange("http://user-service/getUserDetailsForLogin/{privileged}", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}, privileged).getBody();

		LOGGER.info("Response Received as " + response);

		return "privileged Name -  " + privileged + " \n Login User Details " + response;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
