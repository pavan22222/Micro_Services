package com.infinite.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Person_Address")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	@GenericGenerator(name="AddressIdGenerator",strategy ="com.infinite.generators.AddressIdGenerator")
	@GeneratedValue(generator = "AddressIdGenerator")
	private String address_id;
	
	@Column(length = 30,name="door_no")
	private String doorNo;
	
	@Column(length = 30,name="city")
	private String city;
	
	@Column(length = 30,name="pincode")
	private Long pincode;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Person.class,cascade = CascadeType.ALL)
	@JoinColumn(name="person_id",referencedColumnName = "person_id")
	private Person person;

}
