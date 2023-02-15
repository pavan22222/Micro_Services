package com.infinite.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class AddressIdGenerator implements IdentifierGenerator{
	
	private static String initialValue="ngAd-";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		return initialValue+new Random().nextLong();
	}

}
