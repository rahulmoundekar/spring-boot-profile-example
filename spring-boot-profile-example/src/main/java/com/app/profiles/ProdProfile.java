package com.app.profiles;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(value = { "prod" })
@Configuration
public class ProdProfile {

	@PostConstruct
	public void test() {
		System.out.println("Loaded Production environment");
	}

}
