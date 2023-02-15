package com.infinite.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infinite.beans.Student;
import com.infinite.service.StudentService;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/infinite/cfg/applicationContext.xml");
		StudentService service = ctx.getBean("service", StudentService.class);
		ArrayList<String> ids = new ArrayList<>();
		ids.add("ngSt--1524722225435732807");
		/*	List<Student> student=service.fetchAllStudentsByIds(ids);
			student.forEach(System.out::println);*/
		Student st=service.fetchAllStudentsById("ngSt--1524722225435732807");
		System.out.println(st);
	}

}
