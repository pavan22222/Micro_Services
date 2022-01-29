package com.vrnda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServices04FeignClientBankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServices04FeignClientBankServiceApplication.class, args);
	}

}
