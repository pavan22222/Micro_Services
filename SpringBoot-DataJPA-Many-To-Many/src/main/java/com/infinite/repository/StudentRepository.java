package com.infinite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
