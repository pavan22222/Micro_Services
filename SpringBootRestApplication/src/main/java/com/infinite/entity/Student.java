package com.infinite.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;
import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Proxy(lazy = true)
@Table(name = "Student")
@Lazy(value = true)
@NamedQueries(value={
	@NamedQuery(query = "select st from Student st order by st.city desc",name = "getStudentsByPagination")
})
public class Student implements Serializable{
	
	@Id
	@GenericGenerator(name = "studentGenerator",strategy = "com.infinite.generators.StudentGenerator")
	@GeneratedValue(generator = "studentGenerator")
	@Column(name = "student_id")
	private String id;
	@Column(name = "student_name")
	@JsonProperty(required = true)
	private String name;
	@Column
	private String city;
	private String email;
	private Long phoneNumber;
	private Long pincode;
	private Float fee;
	private LocalDateTime doj;
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	
	public Student(String id, String name, String city, Long pincode) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.pincode = pincode;
	}
	
	public Student() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public LocalDateTime getDoj() {
		return doj;
	}

	public void setDoj(LocalDateTime doj) {
		this.doj = doj;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Float getFee() {
		return fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
