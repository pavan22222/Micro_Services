package com.vrnda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vrnda.view.EPFORestConsumer;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EPFORestConsumer consumer;
	
	@GetMapping("/info")
	public String getInfo(@RequestParam Long uan,@RequestParam String passowrd) {
		return consumer.getEPFOServices(uan, passowrd);
	}
}
