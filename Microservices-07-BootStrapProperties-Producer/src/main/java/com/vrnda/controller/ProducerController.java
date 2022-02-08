package com.vrnda.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RefreshScope
public class ProducerController {
	@Value("${username}")
	private String user;
	
	//@Value("${password}")
	private String pwd;
	
	
	@GetMapping("/getCredentials")
	public String getCredentials() {
		return user+pwd;
	}

}
