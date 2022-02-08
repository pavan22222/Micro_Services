package com.vrnda.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProducerConsumer {
	
	@Autowired
	private org.springframework.cloud.client.discovery.DiscoveryClient client;
	
	public String consumeProducerServices() {
		ServiceInstance instance=client.getInstances("Producer-Service").get(0);
		RestTemplate template=new RestTemplate();
		return template.exchange(instance.getUri()+"/producer/getCredentials", HttpMethod.GET, null,String.class).getBody();
	}
}
