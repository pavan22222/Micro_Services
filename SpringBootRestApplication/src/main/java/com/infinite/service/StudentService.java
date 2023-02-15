package com.infinite.service;

import java.util.List;

import com.infinite.entity.Student;

public interface StudentService {
	
	List<Student> getStudentByCity(String cityName);
	
	String saveStudent(Student st);
	
	List<Student> getStudensByPagination(Integer startIndex,Integer lastIndex);
	
	Integer fetchCountOfStudents();
	
	Student getStudentById(String stduentId);

}
