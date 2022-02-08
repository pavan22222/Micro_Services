package com.vrnda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Microservices07BootStrapPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservices07BootStrapPropertiesApplication.class, args);
	}

}
