package com.infinite.runners;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infinite.entity.Student;
import com.infinite.repository.StudentRepository;
import com.infinite.view.ResultView;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner{
	
	@Autowired
	private StudentRepository repository;

	@Override
	public void run(String... args) throws Exception {
		//getStduentByName("Pavan");
		//getStduentByNameAndAge("Adams",18);
		//getStduentByIdOrDob(14,new Date("2009/01/10"));
		//getStduentByDobIs(new Date("2009/01/10"));
		//getStduentByDobEquals(new Date("2009/01/10"));
		//getStduentByDobBetween(new Date("2000/01/10"),new Date("2029/01/10"));
		//getStduentByAgeLessThan(200);
		//getStduentByAgeLessThanEqual(23);
		//getStduentByAgeGreaterThan(23);
		//getStduentByAgeGreaterThanEqual(23);
		//getStduentByAgeAfter(23);
		//getStduentByAgeBefore(23);
		//getStduentByFailedIsNotNull();
		//getStduentByFailedIsNotNull();
		//getStduentByStudentNameLike("pav");
		//getStduentByStudentNameNotLike("pav");
		//getStduentByStudentNameStartingWith("pav");
		//getStduentByStudentNameEndingWith("pav");
		//getStduentByStudentNameContaining("am");
		//getStudentNameOrderByStudentNameAsc("Adams");
		//getStduentByStudentNameNot("Pavan");
		//getStduentByAgeIn();
		//getStduentByAgeNotIn();
		//getStduentByStudentNameIgnoreCase("adams");
		//getStduentByFailedTrue();
		//getStduentByFailedFalse();
		//getStduentByByAgeInOrStudentNameEqual();
		getStudentsByFailedIsNull();
	}
	
	private void getStduentByName(String name) {
		Student student=repository.findByStudentName(name);
		System.out.println(student);
	}
	
	private void getStduentByNameAndAge(String name,Integer age) {
		Student student=repository.findByStudentNameAndAge(name,age);
		System.out.println(student);
	}
	
	private void getStduentByIdOrDob(Integer id,Date date) {
		List<Student> students=repository.findByStudentIdOrDob(id, date);
		students.forEach(System.out::println);
	}
	
	private void getStduentByDobIs(Date date) {
		Student student=repository.findByDobIs(date);
		System.out.println(student);
	}
	
	private void getStduentByDobEquals(Date date) {
		Student student=repository.findByDobEquals(date);
		System.out.println(student);
	}
	
	private void getStduentByDobBetween(Date lowerDate,Date higherDate) {
		List<Student> students=repository.findByDobBetween(lowerDate,higherDate);
		students.forEach(System.out::println);
	}
	
	private void getStduentByAgeLessThan(Integer age) {
		List<Student> students=repository.findByAgeLessThan(age);
		students.forEach(System.out::println);
	}
	
	private void getStduentByAgeLessThanEqual(Integer age) {
		List<Student> students=repository.findByAgeLessThanEqual(age);
		students.forEach(System.out::println);
	}
	
	private void getStduentByAgeGreaterThan(Integer age) {
		List<Student> students=repository.findByAgeGreaterThan(age);
		students.forEach(System.out::println);
	}
	
	private void getStduentByAgeGreaterThanEqual(Integer age) {
		List<Student> students=repository.findByAgeGreaterThanEqual(age);
		students.forEach(System.out::println);
	}
	
	private void getStduentByAgeAfter(Integer age) {
		List<Student> students=repository.findByAgeAfter(age);
		students.forEach(System.out::println);
	}
	
	private void getStduentByFailedIsNotNull() {
	//	List<Student> students=repository.findByFailedIsNotNull();
	//	students.forEach(System.out::println);
	}
	
	private void getStduentByFailedIsNull() {
		//List<Student> students=repository.findByFailedIsNull();
		//students.forEach(System.out::println);
	}
	
	private void getStduentByStudentNameLike(String studentName) {
		List<Student> students=repository.findByStudentNameLike(studentName);
		students.forEach(System.out::println);
	}
	
	private void getStduentByStudentNameNotLike(String studentName) {
		List<Student> students=repository.findByStudentNameNotLike(studentName);
		students.forEach(System.out::println);
	}
	
	private void getStduentByStudentNameStartingWith(String studentName) {
		List<Student> students=repository.findByStudentNameStartingWith(studentName);
		students.forEach(System.out::println);
	}
	
	private void getStduentByStudentNameEndingWith(String studentName) {
		List<Student> students=repository.findByStudentNameEndingWith(studentName);
		students.forEach(System.out::println);
	}
	
	private void getStduentByStudentNameContaining(String studentName) {
		List<Student> students=repository.findByStudentNameContaining(studentName);
		students.forEach(System.out::println);
	}
	
	private void getStudentNameOrderByStudentNameAsc(String studentName) {
		List<Student> students=repository.findByStudentNameOrderByStudentNameAsc(studentName);
		students.forEach(System.out::println);
	}
	
	private void getStduentByStudentNameNot(String studentName) {
		List<Student> students=repository.findByStudentNameNot(studentName);
		students.forEach(System.out::println);
	}
	
	private void getStduentByAgeIn() {
		Set<Integer> set=new HashSet();
		set.add(12);
		set.add(20);
		set.add(18);
		set.add(34);
		List<Student> students=repository.findByAgeIn(set);
		students.forEach(System.out::println);
	}
	
	private void getStduentByAgeNotIn() {
		Set<Integer> set=new HashSet();
		set.add(12);
		set.add(20);
		set.add(18);
		set.add(34);
		List<Student> students=repository.findByAgeNotIn(set);
		students.forEach(System.out::println);
	}
	
	private void getStduentByFailedTrue() {
		List<Student> students=repository.findByFailedTrue();
		students.forEach(System.out::println);
	}
	
	
	private void getStduentByFailedFalse() {
		List<Student> students=repository.findByFailedFalse();
		students.forEach(System.out::println);
	}
	
	private void getStduentByStudentNameIgnoreCase(String name) {
		List<Student> students=repository.findByStudentNameIgnoreCase(name);
		students.forEach(System.out::println);
	}
	
	private void getStduentByByAgeInOrStudentNameEqual() {
		Set<Integer> ages=new HashSet<Integer>();
		ages.add(18);
		ages.add(20);
		ages.add(28);
		ages.add(22);
		List<Student> students=repository.findByAgeInOrStudentNameEquals(ages, "Crist");
		students.forEach(System.out::println);
	}
	
	private void getStudentsByFailedIsNull() {
		List<ResultView> results=repository.findByFailedIsNull();
		results.forEach(result ->{
			System.out.println(result.getAge());
			System.out.println(result.getStudentId());
			System.out.println(result.getStudentName());
			System.out.println(result.getClass().getName());
		});
	}

}
