package com.vrnda.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class ProducerController {
	
	@Value("${username}")
	private String userName;
	@Value("${password}")
	private String password;
	
	
	@GetMapping("/getDetails")
	public String getDetails() {
		return " From Producer  "+userName+" "+password;
	}
}
