package com.vrnda.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/epfo")
public class EpfoController {
	
	@Value("${server.port}")
	private Integer port;
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	
	@GetMapping("getEpfoDetails/{uan}/{password}")
	public String getEpfoDetails(@PathVariable Long uan,@PathVariable String password) {
		return "You Epfo Details are"+uan+"..."+password+" with the port "+port+" with the instance id"+instanceId;
	}
	
}
