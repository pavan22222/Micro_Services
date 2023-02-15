package com.infinite.runners;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.infinite.entity.Phone;
import com.infinite.entity.PhoneNumber;
import com.infinite.repository.PhoneNumberRepository;
import com.infinite.repository.PhoneRepository;
@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner{
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired	
	private PhoneNumberRepository phoneNumberRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//saveObjectsUsingParent();
		//saveObjectsUsingChild();
		//loadObjectsUsingParent();
		//loadObjectsUsingChild();
		//deleteObjectsUsingChild();
		//deleteObjectsUsingParent();
		//deleteOneChildOfParent();
		//deleteChildObject();
		loadPhones();
	}
	
	private void saveObjectsUsingParent() {
		PhoneNumber ph1=new PhoneNumber(null,222222222l,null);
		PhoneNumber ph2=new PhoneNumber(null,4444444444l,null);
		List<PhoneNumber> phoneNumbers=new ArrayList<>();
		phoneNumbers.add(ph1);
		phoneNumbers.add(ph2);
		Phone phone=new Phone(null, "Lenovo", 12000f, new Date(), phoneNumbers);
		ph1.setPhone(phone);ph2.setPhone(phone);
		phoneRepository.save(phone);		
	}
	
	private void saveObjectsUsingChild() {
		PhoneNumber ph1=new PhoneNumber(1003,555555555l,null);
		Phone phone=new Phone(1, "Lenovo", 13000f, new Date(), null);
		ph1.setPhone(phone);
		phoneNumberRepository.save(ph1);
		
	}
	
	private void loadObjectsUsingParent() {
		List<Phone> phones=phoneRepository.findAll();
		phones.forEach(phone->{
			System.out.println(phone.getPhoneNumbers());
		});
		
	}
	
	private void loadObjectsUsingChild() {
		phoneNumberRepository.findAll().forEach(phonenNumber->{
			System.out.println(phonenNumber.getPhone());
		});
		
	}
	
	private void deleteObjectsUsingChild() {
		Optional<PhoneNumber> optional=phoneNumberRepository.findById(1000);
		if(optional.isPresent()) {
			PhoneNumber phoneNumber=optional.get();
			//phoneNumber.setPhone(null);
			phoneNumberRepository.delete(phoneNumber);
		}
		
	}
	
	private void deleteObjectsUsingParent() {
		Optional<Phone> optional=phoneRepository.findById(1);
		if(optional.isPresent()) {
			Phone phone=optional.get();
			//phoneNumber.setPhone(null);
			phoneRepository.delete(phone);
		}
		
	}
	
	private void deleteOneChildOfParent() {
		Optional<Phone> optional=phoneRepository.findById(1);
		if(optional.isPresent()) {
			Phone phone=optional.get();
			phone.getPhoneNumbers().remove(0);
			phoneRepository.save(phone);
		}
		
	}
	
	private void deleteChildObject() {
		Optional<PhoneNumber> optional=phoneNumberRepository.findById(1002);
		if (optional.isPresent()) {	
			PhoneNumber phoneNumber=optional.get();
			//phoneNumber.setPhone(null);
			phoneNumberRepository.delete(phoneNumber);
		}
	}
	
	private void loadPhones() {
		List<Phone> phones=phoneRepository.getPhones();
		phones.forEach(phone->{
			System.out.println(phone.getPhoneNumbers());
		});
		
	}

}
