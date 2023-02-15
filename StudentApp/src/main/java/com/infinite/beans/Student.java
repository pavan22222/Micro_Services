package com.infinite.beans;

public class Student {

	private String studentId;
	private String studentName;
	private String city;
	private Long pincode;

	public Student() {

	}

	public Student(String id, String name, String city, Long pincode) {
		super();
		this.studentId = id;
		this.studentName = name;
		this.city = city;
		this.pincode = pincode;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
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

}
