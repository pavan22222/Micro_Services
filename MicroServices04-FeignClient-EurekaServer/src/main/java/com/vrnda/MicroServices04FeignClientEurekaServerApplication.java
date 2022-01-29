package com.vrnda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServices04FeignClientEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServices04FeignClientEurekaServerApplication.class, args);
	}

}
