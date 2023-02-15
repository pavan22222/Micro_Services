package com.infinite.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.infinite.beans.WishMessageGenerator;

public class Test 
{
    public static void main( String[] args )
    {
       FileSystemResource rsource=new FileSystemResource("src/main/java/com/infinite/configuration/applicationContext.xml");
       ClassPathResource classPathResource= new ClassPathResource("applicationContext.xml");
       BeanFactory factory= new XmlBeanFactory(classPathResource);
       WishMessageGenerator generator=factory.getBean("com.infinite.beans.WishMessageGenerator", WishMessageGenerator.class);
       System.out.println(generator.getMessage());
    }
}
