package com.vrnda.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EPFORestConsumer {
	
	@Autowired
	private DiscoveryClient client;
	
	public String getEPFOServices(Long uan,String password) {
		System.out.println("EPFORestConsumer.getEPFOServices()");
		List<ServiceInstance> instances=client.getInstances("EPFO-Service");
		System.out.println(instances.get(0).getUri()+"..."+instances.get(0).getHost()+".."+instances.get(0).getPort());
		String url=instances.get(0).getUri()+"/epfo/epfoInfo/{uan}/{password}";
		RestTemplate template=new RestTemplate();
		return template.getForEntity(url, String.class, uan,password).getBody();
	}
}
