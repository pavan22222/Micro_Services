package com.infinite.generators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class PhoneNumberIdGenerator implements IdentifierGenerator{
	
	private static Integer initialValue=1002;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		return initialValue++;
	}

}
