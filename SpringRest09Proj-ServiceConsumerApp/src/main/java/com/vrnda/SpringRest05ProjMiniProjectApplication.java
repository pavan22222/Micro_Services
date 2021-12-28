package com.vrnda;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class SpringRest05ProjMiniProjectApplication {
	private static Logger logger=Logger.getLogger(SpringRest05ProjMiniProjectApplication.class);
	
static {
	ClassPathResource cprs=new ClassPathResource("log4j.properties");
	try {
		PropertyConfigurator.configure(cprs.getInputStream());
	} catch (IOException e) {
		logger.fatal(e);
	}
	}
	public static void main(String[] args) {
		logger.debug("main");
		SpringApplication.run(SpringRest05ProjMiniProjectApplication.class, args);
	}

}
