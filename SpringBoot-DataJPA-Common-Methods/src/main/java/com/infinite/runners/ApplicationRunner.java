package com.infinite.runners;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.infinite.entity.Student;
import com.infinite.repository.StudentRepository;

@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

	@Autowired
	private StudentRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//saveStudent();
		//saveAllStudent();
		//findCountOfEmployees();
		employeeExistsById();
		deleteEmployeeById();
		findEmployeeById();
		deleteAllEmployeesByIds();
	}

	private void saveStudent() {
		Student st = new Student(null, "Jhon", 28, new Date());
		Student result = repository.save(st);
		System.out.println("Saved Employee is:: " + result);
	}

	private void saveAllStudent() {
		Student st1 = new Student(null, "Adams", 18, new Date("2002/12/12"));
		Student st2 = new Student(null, "Crist", 23, new Date("2009/01/10"));
		Student st3 = new Student(null, "Abhraham", 22, new Date("2005/10/12"));
		List<Student> students = new ArrayList<Student>();
		students.add(st1);
		students.add(st2);
		students.add(st3);
		Iterable<Student> results = repository.saveAll(students);
		Iterator<Student> iterator = results.iterator();
		System.out.println("Saved Employees :: [{");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			System.out.println("]},");
		}
	}

	private void findCountOfEmployees() {
		System.out.println("Count of Employees is::" + repository.count());
	}
	
	private void employeeExistsById() {
		Integer employeeId=13;
		System.out.println("Employees exists with the Id? "+employeeId+ " ::" + repository.existsById(13));
	}
	
	private void deleteEmployeeById() {
		try {
		repository.deleteById(173);
		}catch (EmptyResultDataAccessException e) {
			System.out.println("No Employee exists with the id::"+173);
		}
	}
	
	private void findEmployeeById() {
		Optional<Student> optional = repository.findById(150);
		optional.ifPresent(System.out::println);
	}
	
	private void deleteAllEmployeesByIds() {
		List<Integer> ids = new ArrayList<Integer>();
		try {			
			ids.add(1);
			ids.add(10);
			ids.add(19);
			ids.add(100);
			repository.deleteAllById(ids);
		} catch (EmptyResultDataAccessException e) {
			System.out.println("No Employee exists with the ids::" + ids);
		}
	}

}
