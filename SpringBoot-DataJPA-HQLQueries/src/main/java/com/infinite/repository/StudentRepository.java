package com.infinite.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infinite.entity.Student;
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query("select st from com.infinite.entity.Student st")
	List<Student> fectchAllStudents();
	
	@Query("select st from com.infinite.entity.Student st where studentName like :studentName")
	List<Student> fectchAllStudentsByStudentNameLike(@Param("studentName") String studentName);
	
	@Query("select st.studentId,st.age from com.infinite.entity.Student st where studentName like :studentName")
	List<Object[]> fectchSpecificColsOfStudentsByStudentNameLike(@Param("studentName") String studentName);
	
	@Query("select st.studentId from com.infinite.entity.Student st where studentName like :studentName")
	List<Integer> fectchSingleColOfStudentsByStudentNameLike(@Param("studentName") String studentName);
	
	@Query("select COUNT(*) from Student")
	Integer fetchCountOfStudents();
	
	@Query("select COUNT(*),MAX(st.age),MIN(st.studentId),SUM(st.age) from Student st")
	Object fecthAggregateValues();
	
	@Query("update Student st set st.studentName=:studentName,st.age=:age,st.dob=:dob where st.studentId=:studentId")
	@Modifying
	int updateStudent(@Param("studentName") String studentName, @Param("age") Integer age, Date dob, Integer studentId);
	
	@Query(value="insert into [dbo].[Student](student_id,age,dob,student_name,failed) values(:studentId,:age,:dob,:studentName,:failed)",nativeQuery = true)
	@Modifying
	int insertStudent(Integer studentId,Integer age, Date dob,@Param("studentName") String studentName,Boolean failed);
	
	@Query("delete from Student where studentId=?1 and age=?2")
	@Modifying
	int deleteStudent(Integer studentId,Integer age);
	
	@Query(value="SELECT CONVERT(DATE,GETDATE())",nativeQuery = true)
	Date fetchCurrentDate();
}
