package com.infinite.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.infinite.beans.Backend;
import com.infinite.beans.Frontend;

public class Test 
{
    public static void main( String[] args )
    {
      DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
      XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
      reader.loadBeanDefinitions("applicationContext.xml");
      Backend backend=beanFactory.getBean("backend", Backend.class);
      Frontend frontend=beanFactory.getBean("com.infinite.beans.Frontend", Frontend.class);
      System.out.println(backend+" "+frontend);
      
    }
}
