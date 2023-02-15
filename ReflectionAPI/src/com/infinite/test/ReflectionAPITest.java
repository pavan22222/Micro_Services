package com.infinite.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class ReflectionAPITest {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		System.out.println("Hello");
		Scanner scanner=new Scanner(System.in);
		String className="java.util.Date";
		System.out.println("Class Name::"+className);
		Class clazz=Class.forName(className);
		//System.out.println(createObject(clazz));
		System.out.println(".................................................");
		System.out.println(createObject("person",Person.class));
	}
	
	
	
	
	private static <S extends Object> S createObject(Class<S> clazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		//return clazz.newInstance();
		return (S) clazz.getDeclaredConstructors()[0].newInstance(null);
	}
	
	public static class Person{
		
	}
	
	public static class Employee extends Person{
		
	}
	
	public static class Student extends Person{
	
	}
	

	private static <S extends Person> S createObject(String type,Class<S> clazz) throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}


}
