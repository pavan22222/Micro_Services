package com.vrnda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vrnda.beans.Computer;

@Service
public class ComputerServiceImpl  implements IComputerService{
	@Autowired
	private Environment environment;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper objectMapper;
	@Override
	public List<Computer> retrieveAllComputers() throws Exception {
		ResponseEntity<String> responseBody=restTemplate.exchange(environment.getProperty("getAllUrl"), HttpMethod.GET,null, String.class);
		System.out.println(""+responseBody.getBody());
		return objectMapper.readValue(responseBody.getBody(),new TypeReference<List<Computer>>() {});
	}

}
