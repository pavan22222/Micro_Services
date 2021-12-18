package com.vrnda.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.web.JsonPath;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity(name = "COMPUTERS")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Computers {
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hardwareId",length = 20)
	private Long hardwareId;
	@NonNull
	private String company;
	@Column(length=25)
	@NonNull
	private String hdd;
	@Column(length=30)
	@NonNull
	private String ssd;
	@Column(length=30)
	@NonNull
	private String ram;
	@Column(length=30)
	@NonNull
	private Double price;
	@Column()
	@NonNull
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dom;
}
