package com.vrnda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Microservices07BootStrapPropertiesConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Microservices07BootStrapPropertiesConfigServerApplication.class, args);
	}

}
