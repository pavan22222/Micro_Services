package com.infinite.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Student")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GenericGenerator(name="studentIdGenerator",strategy ="com.infinite.generators.StudentIdGenerator")
	@GeneratedValue(generator = "studentIdGenerator")
	@Column(name="student_id",length=255)
	private String studentId;
	
	@Column(length = 30,name="studentName")
	private String studentName;
	
	@Column(length = 30,name="city")
	private String city;
	
	@Column(length = 30,name="pincode")
	private Long pincode;
	
	@ManyToMany(targetEntity = Teacher.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "Teacher_Student",
	joinColumns= @JoinColumn(name="student_id"),
	inverseJoinColumns = @JoinColumn(name="teacher_id"))
	private Set<Teacher> teachers;

}
