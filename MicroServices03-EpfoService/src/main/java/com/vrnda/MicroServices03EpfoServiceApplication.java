package com.vrnda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServices03EpfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServices03EpfoServiceApplication.class, args);
	}

}
