package com.infinite.runners;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.infinite.entity.Student;
import com.infinite.entity.Teacher;
import com.infinite.repository.StudentRepository;
import com.infinite.repository.TeacherRepository;
@Component
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//saveTeacher();
		removeOneTeacherForAnStudent("ngSt--3937374544794546447", 103l);
	}
	
	private void saveTeacher() {
		Student st1=new Student(null, "James", "London", 233333l, null);
		Student st2=new Student(null, "Adams", "Chicaco", 4445333l, null);
		Student st3=new Student(null, "Liz", "New York", 556333l, null);
		Set<Student> teacher1Students=new HashSet<>();
		teacher1Students.add(st1);teacher1Students.add(st2);
		Set<Student> teacher2Students=new HashSet<>();
		teacher2Students.add(st2);teacher2Students.add(st3);
		Teacher teacher1=new Teacher(null, "Martin", teacher1Students);
		Teacher teacher2=new Teacher(null, "Kane", teacher2Students);
		Set<Teacher> student1Teachers=new HashSet<>();
		student1Teachers.add(teacher1);
		st1.setTeachers(student1Teachers);
		Set<Teacher> student2Teachers=new HashSet<>();
		student2Teachers.add(teacher1);student2Teachers.add(teacher2);
		st2.setTeachers(student2Teachers);
		Set<Teacher> student3Teachers=new HashSet<>();
		student3Teachers.add(teacher2);
		st3.setTeachers(student3Teachers);
		Set<Teacher> teachers=new HashSet<>();
		teachers.add(teacher1);teachers.add(teacher2);
		teacherRepository.saveAll(teachers);
	}
	
	private void removeOneTeacherForAnStudent(String studentId,Long teacherId) {	
		Optional<Student> optional=studentRepository.findById(studentId);
		if(optional.isPresent()) {
			Student student=optional.get();
			Teacher teacher=teacherRepository.findById(teacherId).get();
			Teacher removedTeacher=student.getTeachers().stream().filter(teacher1 -> teacher1.getTeacherId().equals(teacher.getTeacherId())).
			collect(Collectors.toList()).get(0);
			System.out.println(student.getTeachers().remove(removedTeacher));
			studentRepository.save(student);
		}
	}

}
