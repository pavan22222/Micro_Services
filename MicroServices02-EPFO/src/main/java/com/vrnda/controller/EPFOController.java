package com.vrnda.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/epfo")
public class EPFOController {
	
	@GetMapping("/epfoInfo/{uan}/{password}")
	public String getInfo(@PathVariable Long uan,@PathVariable String  password) {
		return "Your EPFO Info is::"+uan+"...."+password;
	}
}
