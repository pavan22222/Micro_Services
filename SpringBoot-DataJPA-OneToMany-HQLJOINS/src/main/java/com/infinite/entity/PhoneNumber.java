package com.infinite.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "Phone_Phone_Number")
@NoArgsConstructor
public class PhoneNumber {
	
	@Id
	//@GenericGenerator(name = "PhoneNumberIdGenerator",strategy = "com.infinite.generators.PhoneNumberIdGenerator")
	@GeneratedValue(generator = "PhoneNumberIdGenerator")
	@Column(name = "phone_number_id")
	private Integer phoneNumberId;
	@Column(name = "phone_number",length = 30)
	private Long phoneNumber;
	
	@ManyToOne(targetEntity = Phone.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "phone_id")
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Fetch(FetchMode.JOIN)
	private Phone phone;
	

}
