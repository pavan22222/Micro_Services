package com.vrnda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Microservices05ConfigServerProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservices05ConfigServerProducerApplication.class, args);
	}

}
