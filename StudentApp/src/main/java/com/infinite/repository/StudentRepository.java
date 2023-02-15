package com.infinite.repository;

import java.util.List;

import com.infinite.beans.Student;

public interface StudentRepository {
	
	int[] saveEmployee(List<Student> students);
	
	List<Student> getAllStudentsByIds(List<String> ids);
	
	Student getAllStudentsById(String id);

}
