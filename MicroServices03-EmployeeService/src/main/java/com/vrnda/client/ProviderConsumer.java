package com.vrnda.client;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProviderConsumer {
	
	@Autowired
	public LoadBalancerClient client;
	
	public String consumeEpfoServices(Long uan,String password) {
		ServiceInstance instance=client.choose("EPFO-Service");
		System.out.println(instance.getPort()+"..."+instance.getInstanceId());
		String url=instance.getUri()+"/epfo/getEpfoDetails/{uan}/{password}";
		RestTemplate template=new RestTemplate();
		return template.exchange(url, HttpMethod.GET, null,String.class, Map.of("uan",uan,"password",password)).getBody();
	}

}
