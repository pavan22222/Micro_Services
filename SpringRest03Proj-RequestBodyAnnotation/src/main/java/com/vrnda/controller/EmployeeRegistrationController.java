package com.vrnda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vrnda.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRegistrationController {
	
	@PostMapping("/register")
	public String register(@RequestBody Employee emp) {
		return emp.toString();
	}
	
	@GetMapping("/get")
	public String get() {
		return "Pavan";
	}
}
