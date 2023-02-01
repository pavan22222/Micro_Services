package com.infinite.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infinite.entity.Student;


public interface StudentRepository extends JpaRepository<Student, String>{
	
	@Query(value = "select * from Student where city=:city",nativeQuery = true)
	List<Student> findByCity(@Param("city") String cityName);
	
	
	@Query(value = "insert into Student(student_id,student_name,city,pincode) values(?,?,?,?)",nativeQuery = true)
	@Modifying
	Integer saveStudent(String id,String name,String city,Long pincode);

}
