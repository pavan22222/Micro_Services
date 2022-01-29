package com.vrnda.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Customer {
	private Integer id;
	private String name;
	private Date doc;
}
