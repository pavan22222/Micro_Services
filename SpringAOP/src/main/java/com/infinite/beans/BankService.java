package com.infinite.beans;

import org.springframework.stereotype.Component;

@Component
public class BankService {
	
	public Float getBalance(Long accNo) {
		System.out.println(accNo);
		return 32000.08f;
	}
	
	public String deposite(Long accNo,float balance) {
		return "Money deposited to the account no::"+accNo+" with the balance::"+balance;
	}
	
	public String withdraw(Long accNo,float balance) throws IllegalAccessException {
		if(true)
			throw new IllegalAccessException("My Throws");
		return "Money withdrawn from the account no::"+accNo+" with the balance::"+balance;
	}

}
