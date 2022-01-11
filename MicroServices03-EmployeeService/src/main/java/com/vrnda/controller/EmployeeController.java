package com.vrnda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vrnda.client.ProviderConsumer;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private ProviderConsumer consumer;
	
	@GetMapping("getInfo")
	public String getInfo(@RequestParam Long uan,@RequestParam String password) {
		return consumer.consumeEpfoServices(uan, password);
		
	}
}
