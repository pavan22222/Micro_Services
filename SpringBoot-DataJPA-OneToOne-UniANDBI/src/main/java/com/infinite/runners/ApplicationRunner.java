package com.infinite.runners;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.infinite.entity.Address;
import com.infinite.entity.PassPort;
import com.infinite.entity.Person;
import com.infinite.repository.AddressRepository;
import com.infinite.repository.PassPortRepository;
import com.infinite.repository.PersonRepository;
@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PassPortRepository passPortRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		savePerson();
	}
	
	private void savePerson() {
		Optional<Address> optional =addressRepository.findById("ngAd--7760650271279407225");
		if(optional.isPresent()) {
			Address address=optional.get();
			PassPort passPort=new PassPort(null,"XXXXXX",new Date(),null);
			Set<Address> addresses=new HashSet<>();
			addresses.add(address);
			Person person=new Person(null,"Adams",addresses,passPort);
			passPort.setPerson(person);
			address.setPerson(person);
			addressRepository.save(address);
		}
		
	}

}
