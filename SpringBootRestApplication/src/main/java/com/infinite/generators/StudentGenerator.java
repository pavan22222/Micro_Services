package com.infinite.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

public class StudentGenerator implements org.hibernate.id.IdentifierGenerator{
	
	private String prefix="ngSt-";
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return prefix+new Random().nextLong();
	}

}
