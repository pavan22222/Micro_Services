package com.vrnda.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vrnda.entity.Computer;

@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void run(String... args) throws Exception {
		String getUrl = "http://localhost:8080/SpringRest08Proj-ServiceProviderApp/computer/getComputerName";
		String getUrlWithPathVariables = "http://localhost:8080/SpringRest08Proj-ServiceProviderApp/computer/getComputerDetails/{computerName}";
		String postUrlWithJson = "http://localhost:8080/SpringRest08Proj-ServiceProviderApp/computer/save/Pavan";
		String getUrlWithListOfJson = "http://localhost:8080/SpringRest08Proj-ServiceProviderApp/computer/getAll";
		// Consuming Other Restful Application services in get mode request without path
		// variables
		ResponseEntity<String> response = restTemplate.exchange(getUrl, HttpMethod.GET, null, String.class);
		System.out.println("Response Body::" + response.getBody());
		System.out.println("Response  Status Code::" + response.getStatusCode());
		System.out.println("Response  Status Code Value::" + response.getStatusCodeValue());
		System.out.println("..........................................................................");
		// Consuming Other Restful Application services in get mode request without path
		// variables
		ResponseEntity<String> response1 = restTemplate.exchange(getUrlWithPathVariables, HttpMethod.GET, null,
				String.class, " DELL");
		System.out.println("Response Body::" + response1.getBody());
		System.out.println("Response  Status Code::" + response1.getStatusCode());
		System.out.println("Response  Status Code Value::" + response1.getStatusCodeValue());
		System.out.println("..........................................................................");
		// Consuming Other Restful Application services in post mode request with body
		// as json content type
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		String jsonBody = "{\"company\":\"Lenovo\"}";
		HttpEntity<String> request=new HttpEntity<String>(jsonBody, header);
		ResponseEntity<String> response2 = restTemplate.exchange(postUrlWithJson, HttpMethod.POST, request, String.class);
		System.out.println("Response Body::" + response2.getBody());
		System.out.println("Response  Status Code::" + response2.getStatusCode());
		System.out.println("Response  Status Code Value::" + response2.getStatusCodeValue());
		System.out.println("Response  Headers::" + response2.getHeaders().getContentType());
		
		//converting json response of string into java object
		ObjectMapper mapper=new ObjectMapper();
		Computer res=mapper.readValue( response2.getBody(), Computer.class);
		System.out.println(res);
		String jsonObj=mapper.writeValueAsString(res);
		System.out.println(jsonObj);
		
		System.out.println("----------------------------------------------");
		
		ResponseEntity<String> response3=restTemplate.exchange(getUrlWithListOfJson,HttpMethod.GET, null,String.class);
		System.out.println("Response Body::" + response3.getBody());
		System.out.println("Response  Status Code::" + response3.getStatusCode());
		System.out.println("Response  Status Code Value::" + response3.getStatusCodeValue());
		System.out.println("Response  Headers::" + response3.getHeaders().getContentType());
		
		//converting list of json objects into computer objects using Array
		List<Computer> list=Arrays.asList(mapper.readValue(response3.getBody(), Computer[].class));
		list.forEach(System.out::println); 
		
		System.out.println("----------------------------------------------");
		
		//convertion using predefined abstarct class TypeRefernce
		list=mapper.readValue(response3.getBody(), new TypeReference<List<Computer>>() {
		});
		list.forEach(System.out::println); 
	}

}
