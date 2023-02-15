package com.infinite.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infinite.beans.SingleTon;

public class Test {
	public static void main(String[] args) {
		/*	DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
			XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
			reader.loadBeanDefinitions("applicationContext.xml");*/
		//FileSystemXmlApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/java/com/infinite/configuration/applicationContext.xml");
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		SingleTon singleTon = ctx.getBean("singleTon", SingleTon.class);
		System.out.println(singleTon.getName());
		ctx.close();

	}
}
