package com.vrnda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Microservices06NativeConfigConfigServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservices06NativeConfigConfigServer1Application.class, args);
	}

}
