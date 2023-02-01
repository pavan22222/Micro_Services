package com.infinite.service;

import java.util.List;

import com.infinite.entity.Student;

public interface StudentService {
	
	List<Student> getStudentByCity(String cityName);
	
	Integer saveStudent(String id,String name,String city,Long pincode);
	
	List<Student> getStudensByPagination(Integer startIndex,Integer lastIndex);
	
	Integer fetchCountOfStudents();

}
