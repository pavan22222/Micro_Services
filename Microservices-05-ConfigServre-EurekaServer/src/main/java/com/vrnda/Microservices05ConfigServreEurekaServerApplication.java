package com.vrnda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Microservices05ConfigServreEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservices05ConfigServreEurekaServerApplication.class, args);
	}

}
