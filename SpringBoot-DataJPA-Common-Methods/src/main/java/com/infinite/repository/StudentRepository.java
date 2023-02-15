package com.infinite.repository;

import org.springframework.data.repository.CrudRepository;

import com.infinite.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
