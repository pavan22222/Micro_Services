package com.vrnda.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Employee {
	private Integer id;
	private String name;
	private Double salary;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime doj;
	private List<Long> phoneNumbers;
	private Map<String,String> idCardsDetails;
	private Address address;
}
