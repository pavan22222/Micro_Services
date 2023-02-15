package com.infinite.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.infinite.entity.Student;

public interface StudentRepository extends PagingAndSortingRepository<Student, Integer>{

}
