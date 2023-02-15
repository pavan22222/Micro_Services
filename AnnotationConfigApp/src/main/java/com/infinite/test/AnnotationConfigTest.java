package com.infinite.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infinite.beans.Phone;
import com.infinite.beans.PropertiesFileReader;

public class AnnotationConfigTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("com/infinite/config/applicationContext.xml");
		Phone phone=ctx.getBean("phone", Phone.class);
		System.out.println(phone.getSim().getClass().getName());
		System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
		System.out.println(ctx.getBeanDefinitionCount());
		PropertiesFileReader reader=ctx.getBean("propertiesFileReader", PropertiesFileReader.class);
		System.out.println(reader);
	}

}
