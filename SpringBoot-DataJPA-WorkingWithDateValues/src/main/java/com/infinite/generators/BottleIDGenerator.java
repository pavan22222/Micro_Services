package com.infinite.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class BottleIDGenerator implements IdentifierGenerator{
	
	private static final String PREFIX="ngRx-";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		String suffix=null;
		while(true) {
			suffix = Long.valueOf(new Random().nextLong()).toString().substring(0, 4);
			if(suffix.length() == 4 && !suffix.startsWith("-")) {
				return PREFIX+suffix;
			}
		}
		
	}

}
