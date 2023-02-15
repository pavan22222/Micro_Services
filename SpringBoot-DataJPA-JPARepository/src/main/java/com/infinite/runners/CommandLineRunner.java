package com.infinite.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.infinite.entity.Student;
import com.infinite.repository.StudentRepository;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner{
	
	@Autowired
	private StudentRepository repository;

	@Override
	public void run(String... args) throws Exception {
	/**	
		List<Integer> ids=new ArrayList<Integer>();
		ids.add(null);
		ids.add(12);
		ids.add(13);
		findStudentsById(ids); */
	
		/**
		Student st=new Student(null, "Random", 28, new Date());
		saveAndFlushStudent(st); */
		
		/**
		
		ids.add(null);
		ids.add(12);
		ids.add(13);
		deleteAllStudentsById(ids);  */
		
		Student st=new Student(null, null, 28,null);
		Example example=Example.of(st);
		findAllExample(example);
	}
	
	private  void findStudentsById(Iterable<Integer> ids) {
		List<Student> students=repository.findAllById(ids);
		System.out.println(students);
	}
	
	private  void saveAndFlushStudent(Student st) {
		Student result=repository.saveAndFlush(null);
		System.out.println(result);
	}
	
	private void deleteAllStudentsById(Iterable<Integer> ids) {
		repository.deleteAllByIdInBatch(ids);
	}
	
	private  void findAllExample(Example<Student> example) {
		List<Student> students=repository.findAll(example, Sort.by(Sort.Direction.DESC,"studentName"));
		System.out.println(students);
	}
	

}
