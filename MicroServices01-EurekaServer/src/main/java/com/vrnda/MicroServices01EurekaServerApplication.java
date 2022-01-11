package com.vrnda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServices01EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServices01EurekaServerApplication.class, args);
	}

}
