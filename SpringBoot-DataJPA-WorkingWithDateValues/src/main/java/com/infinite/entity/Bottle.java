package com.infinite.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table()
@AllArgsConstructor
@NoArgsConstructor
public class Bottle {
	
	@javax.persistence.Id
	@GenericGenerator(name = "bottleIdGenerator",strategy = "com.infinite.generators.BottleIDGenerator")
	@javax.persistence.GeneratedValue(generator = "bottleIdGenerator")
	private String id;
	@Column(name="company_name",length = 30)
	private String companyName;
	@Column(scale = 2)
	private Float price;
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_manufacture")
	private Date dom;
	@Column(name="date_of_expired")
	private LocalDateTime doe;

}
