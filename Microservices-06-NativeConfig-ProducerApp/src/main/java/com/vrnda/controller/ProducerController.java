package com.vrnda.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	@Value("${dbuser}")
	private String user;
	
	@Value("${dbped}")
	private String pwd;
	
	@GetMapping("/getDetails")
	public String getDetails() {
		return user+" "+pwd;
	}
}
