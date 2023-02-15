package com.infinite.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StudentIdGenerator implements IdentifierGenerator{
	
	private static String initialValue="ngSt-";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return initialValue+new Random().nextLong();
	}

}
