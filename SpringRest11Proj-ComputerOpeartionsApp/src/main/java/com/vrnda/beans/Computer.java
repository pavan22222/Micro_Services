package com.vrnda.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Computer {
	
	private Long hardwareId;
	@NonNull
	private String company;
	@NonNull
	private String hdd;
	@NonNull
	private String ssd;
	@NonNull
	private String ram;
	private Double price;
	@NonNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dom;
}
