package org.sample.springeureka.poc.util;

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		builder.withDetail("details",
				Collections.singletonMap("description", "This is the Login service, which is discovery server aware, and this service will Call User Microservice, fro available login user details, which is again dicovery server aware!!! "));
	}

}
