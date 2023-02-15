package com.infinite.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
	
	@Id
	@SequenceGenerator(name = "teacherSequence",sequenceName = "Teacher_Sequence",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "teacherSequence",strategy = GenerationType.SEQUENCE )
	@Column(name="teacher_id")
	private Long teacherId;
	@Column(name = "teacher_name",length = 30)
	private String teacherName;	
	@ManyToMany(targetEntity = Student.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "teachers")
	private Set<Student> students;

}
