package com.vrnda.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;


@Data
public class Computer {
	
	private Long hardwareId;
	private String company;
	private String hdd;
	private String ssd;
	private String ram;
	private Double price;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dom;
}
