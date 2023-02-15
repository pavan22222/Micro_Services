package com.infinite.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.entity.Student;
import com.infinite.view.ResultView;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	Student findByStudentName(String studentName);
	Student findByStudentNameAndAge(String studentName,Integer age);
	List<Student> findByStudentIdOrDob(Integer studentId,Date dateOfBirth);
	Student findByDobIs(Date dateOfBirth);
	Student findByDobEquals(Date dateOfBirth);
	List<Student> findByDobBetween(Date lowerDate,Date higherDate);
	List<Student> findByAgeLessThan(Integer age);
	List<Student> findByAgeLessThanEqual(Integer age);
	List<Student> findByAgeGreaterThan(Integer age);
	List<Student> findByAgeGreaterThanEqual(Integer age);
	List<Student> findByAgeAfter(Integer age);
	List<Student> findByAgeBefore(Integer age);
	//List<Student> findByFailedIsNull();
	List<Student> findByFailedIsNotNull();
	List<Student> findByStudentNameLike(String studentName);
	List<Student> findByStudentNameNotLike(String studentName);
	List<Student> findByStudentNameStartingWith(String studentName);
	List<Student> findByStudentNameEndingWith(String studentName);
	List<Student> findByStudentNameContaining(String studentName);
	List<Student> findByStudentNameOrderByStudentNameAsc(String studentName);
	List<Student> findByStudentNameNot(String studentName);
	List<Student> findByAgeIn(Collection<Integer> ages);
	List<Student> findByAgeNotIn(Collection<Integer> ages);
	List<Student> findByFailedTrue();
	List<Student> findByFailedFalse();
	List<Student> findByStudentNameIgnoreCase(String studentName);
	List<Student> findByAgeInOrStudentNameEquals(Collection<Integer> ages,String studentName);
	<T extends ResultView> List<T> findByFailedIsNull(Class<T> clazz);

}
