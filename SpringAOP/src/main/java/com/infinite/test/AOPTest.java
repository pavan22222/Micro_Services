package com.infinite.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.infinite.beans.BankService;

public class AOPTest {
	
	public static void main(String[] args) throws IllegalAccessException {
	
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/infinite/cfg/applicationContext.xml");
		BankService bankService=ctx.getBean("bankService", BankService.class);
		System.out.println(bankService.getClass().getName());
		System.out.println(bankService.getBalance(12222l));
		bankService.deposite(122222222l, 1000f);
		bankService.withdraw(122222222l, 1000f);
	}

}
