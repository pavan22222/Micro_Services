package com.vrnda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Microservices06NativeConfigEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservices06NativeConfigEurekaServerApplication.class, args);
	}

}
