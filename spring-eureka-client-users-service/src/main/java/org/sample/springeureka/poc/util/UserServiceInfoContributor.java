package org.sample.springeureka.poc.util;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class UserServiceInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("details",
				Collections.singletonMap("description", "This is the User service, which is discovery server aware, and this service will be Called by login Microservice, fro login User details, which is again dicovery server aware!!! "));
	}

}
