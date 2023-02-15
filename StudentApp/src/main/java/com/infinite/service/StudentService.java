package com.infinite.service;

import java.util.ArrayList;
import java.util.List;

import com.infinite.beans.Student;

public interface StudentService {

	int[] insertEmployee(List<Student> students);

	List<Student>fetchAllStudentsByIds(List<String> ids);

	Student fetchAllStudentsById(String id);

}
