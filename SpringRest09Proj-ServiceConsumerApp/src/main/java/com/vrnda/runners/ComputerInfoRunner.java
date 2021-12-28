package com.vrnda.runners;

import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.net.HttpHeaders;

@RestController
public class ComputerInfoRunner implements ApplicationRunner {
	private static String COMPUTER_NAME_URL="http://localhost:8080/SpringRest08Proj-ServiceProviderApp/computer/getComputerName";
	private static String COMPUTER_INFO_URL="http://localhost:8080/SpringRest08Proj-ServiceProviderApp/computer/getComputerDetails/{computerName}";
	private static String COMPUTER_SAVE_URL="http://localhost:8080/SpringRest08Proj-ServiceProviderApp/computer/save";
	@Override
	public void run(ApplicationArguments args) throws Exception {
		RestTemplate template=new RestTemplate();
		//Consuming Service Provider Get Method without Request Parameters 
		ResponseEntity<String> response=template.getForEntity(COMPUTER_NAME_URL, String.class);
		System.out.println("Response::"+response.getBody());;
		System.out.println("Response Status Code::"+response.getStatusCode());;
		System.out.println("Response Status Code Value::"+response.getStatusCodeValue());;
		
		System.out.println("----------------------------------------------------------");
		
		//Consuming Service Provider Get Method with Request Parameters 
		ResponseEntity<String> response1=template.getForEntity(COMPUTER_INFO_URL, String.class,Map.of("computerName", "DELL"));
		System.out.println("Response::"+response1.getBody());;
		System.out.println("Response Status Code::"+response1.getStatusCode());;
		System.out.println("Response Status Code Value::"+response1.getStatusCodeValue());;
		
		//Using getForObject Method
		String res=template.getForObject(COMPUTER_INFO_URL, String.class,Map.of("computerName", "DELL"));
		System.out.println(res);
		
		//Calling post method of producer app
		org.springframework.http.HttpHeaders header=new org.springframework.http.HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		String json_body="{ \"company\":\"HP\"}";
		HttpEntity<String> request=new HttpEntity<String>(json_body,header);
		ResponseEntity<String> response2=template.postForEntity(COMPUTER_SAVE_URL,request, String.class);
		System.out.println("Response::"+response2.getBody());;
		System.out.println("Response Status Code::"+response2.getStatusCode());;
		System.out.println("Response Status Code Value::"+response2.getStatusCodeValue());;
		System.exit(0);
	}
	
	


}
