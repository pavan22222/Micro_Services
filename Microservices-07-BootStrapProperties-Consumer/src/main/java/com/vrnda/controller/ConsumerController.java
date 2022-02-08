package com.vrnda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vrnda.client.ProducerConsumer;

@RestController
@RefreshScope
@RequestMapping("/consumer")
public class ConsumerController {
	@Value("${username}")
	private String user;
	
	@Value("${password}")
	private String pwd;
	
	@Autowired
	private ProducerConsumer consumer;
	
	@GetMapping("/getCredentials")
	public String getCredentials() {
		System.out.println(user+" "+pwd);
		return consumer.consumeProducerServices();
	}

}
