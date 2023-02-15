package com.infinite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
