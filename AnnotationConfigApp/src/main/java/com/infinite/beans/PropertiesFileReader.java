package com.infinite.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("com/infinite/config/jdbc.properties")
public class PropertiesFileReader {

	@Value("${driverClassName}")
	private String driverClassName;
	
	@Value("${Path}")
	private String path;
	
	@Override
	public String toString() {
		return "PropertiesFileReader [driverClassName=" + driverClassName + ", path=" + path + "]";
	}

}
