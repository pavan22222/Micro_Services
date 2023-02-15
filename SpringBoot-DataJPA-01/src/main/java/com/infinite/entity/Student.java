package com.infinite.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Student")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	@Column(name="student_id")
	@SequenceGenerator(name = "stSeq",sequenceName = "STUDENT_SEQUENCE",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "stSeq",strategy = GenerationType.SEQUENCE)
	private Integer studentId;
	
	@Column(name="student_name",length = 256)
	private String studentName;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="dob")
	private Date dob;
	
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Address> addresses;

}
