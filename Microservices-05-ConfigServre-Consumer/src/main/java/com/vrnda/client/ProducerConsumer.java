package com.vrnda.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("Producer-Service")
public interface ProducerConsumer {
	
	@GetMapping("/producer/getDetails")
	public String getDetails();
}
