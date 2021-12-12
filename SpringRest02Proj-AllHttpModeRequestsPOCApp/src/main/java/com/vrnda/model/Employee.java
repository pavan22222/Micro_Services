package com.vrnda.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {
	private Integer id;
	private String name;
	private String desg;
	private Double salary;
	private String[] hobbies;
	private List<String> technologies;
	private Set<Long> poneNumbers;
	private Map<String,String> addresses;
;
}
