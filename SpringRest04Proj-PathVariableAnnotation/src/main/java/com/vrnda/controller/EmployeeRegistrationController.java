package com.vrnda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeRegistrationController {
	
	@PostMapping("/get/{id}/{name}")
	public String getEmployee(@PathVariable(value="id") Integer id,@PathVariable()String name) {
		return  "getEmployee "+id+" "+name;
	}
	
	@GetMapping("/get/{id}/name")
	public String getEmployee1(@PathVariable(value="id") Integer id,@PathVariable(required = false)String name) {
		return "getEmployee1 "+id+" "+name;
	}
	
	@GetMapping("/get/id/{name}")
	public String getEmployee2(@PathVariable(required = false) Integer id,@PathVariable()String name) {
		return  "getEmployee2 "+id+" "+name;
	}
	
	@GetMapping("/get/id/name")
	public String getEmployee3(@PathVariable(value="id",required = false) Integer id,@PathVariable(required = false)String name) {
		return "getEmployee3 "+id+" "+name;
	}
}
