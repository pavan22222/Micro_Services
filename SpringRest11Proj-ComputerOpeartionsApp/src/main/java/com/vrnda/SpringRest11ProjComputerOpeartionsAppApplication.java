package com.vrnda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringRest11ProjComputerOpeartionsAppApplication {
	
	@Bean
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public ObjectMapper createObejctMapper() {
		return new ObjectMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRest11ProjComputerOpeartionsAppApplication.class, args);
	}

}
