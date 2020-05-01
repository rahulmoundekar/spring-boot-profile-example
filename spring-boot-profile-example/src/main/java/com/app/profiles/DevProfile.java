package com.app.profiles;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value = { "dev" })
@Configuration
public class DevProfile {

	@PostConstruct
	public void test() {
		System.out.println("Loaded DEV environment");
	}

}
