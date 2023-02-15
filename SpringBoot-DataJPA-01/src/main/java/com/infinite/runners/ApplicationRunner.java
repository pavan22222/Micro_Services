package com.infinite.runners;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.infinite.entity.Address;
import com.infinite.entity.Student;
import com.infinite.repository.StudentRepository;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner{
	
	@Autowired
	private StudentRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Address addr1=new Address(null,"345/12","XXX Colony","XXXXXXX","Chicago",18787456l,null);
		Address addr2=new Address(null,"343/23","YYY Colony","YYYYYYY","London",8776788l,null);
		Set<Address> addresses=new HashSet<Address>();
		addresses.add(addr1);
		addresses.add(addr2);
		Student st=new Student(null,"Jhon",28,new Date(),addresses);
		addr1.setStudent(st);
		addr2.setStudent(st);
		Student result=repository.save(st);
		System.out.println(result);

		List<Student> results = (List<Student>) repository.findAll();

		results.stream().forEach(student -> {
			System.out.println(student);
			System.out.println(student.getAddresses());
		});

	}

}
