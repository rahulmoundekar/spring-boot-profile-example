package com.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

	@Value("${basic.message}")
	private String message;

	@RequestMapping("/")
	public String viewProfile() {
		return message;
	}

}
