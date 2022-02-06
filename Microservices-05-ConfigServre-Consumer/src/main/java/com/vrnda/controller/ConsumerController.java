package com.vrnda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vrnda.client.ProducerConsumer;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
	private ProducerConsumer consumer;
	
	@Value("${username}")
	private String userName;
	@Value("${password}")
	private String password;
	
	@GetMapping("/getDetails")
	public String getDetails() {
		System.out.println(userName+"...."+password);
		return consumer.getDetails();
	}
}
