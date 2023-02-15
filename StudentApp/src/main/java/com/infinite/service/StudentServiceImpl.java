package com.infinite.service;

import java.util.List;

import com.infinite.beans.Student;
import com.infinite.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {

	private StudentRepository repository;

	public void setRepository(StudentRepository studentRepository) {
		this.repository = studentRepository;
	}

	@Override
	public int[] insertEmployee(List<Student> students) {
		return repository.saveEmployee(students);
	}

	@Override
	public List<Student> fetchAllStudentsByIds(List<String> ids) {
		return repository.getAllStudentsByIds(ids);
	}

	@Override
	public Student fetchAllStudentsById(String id) {
		return repository.getAllStudentsById(id);
	}

}
