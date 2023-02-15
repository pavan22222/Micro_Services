package com.infinite.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
@Lazy(value = true)
public class Phone {
	
	/*	@Autowired
		@Qualifier("sim1")*/
	private Sim sim;
	
	@Autowired
	Phone(@Qualifier("sim1") Sim sim){
		this.sim=sim;
	}

	public Sim getSim() {
		return sim;
	}
	
	/*@Autowired()
	@Qualifier("sim1")*/
	public void setSim(Sim sim) {
		this.sim = sim;
	}
	
	
	/** orbitary method Injection */
	/*@Autowired()
	@Qualifier("sim1")*/
	public void assign(Sim sim) {
		System.out.println("assign method");
		this.sim = sim;
	}
	
	

}
