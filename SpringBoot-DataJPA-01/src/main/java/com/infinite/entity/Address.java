package com.infinite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Addresses")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

	@Id
	@SequenceGenerator(name = "addrSeq",sequenceName = "ADDRESS_SEQUENCE",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "addrSeq",strategy = GenerationType.SEQUENCE)
	@Column(name="address_id",length=256)
	private Integer addressId;
	
	@Column(name="door_no",length=256)
	private String doorNo;
		
	@Column(name="colony",length=256)
	private String colony;
	
	@Column(name="village",length=256)
	private String village;
	
	@Column(name="city",length=256)
	private String city;
	
	@Column(name="pin_code",length=256)
	private Long pinCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id",referencedColumnName = "student_id",nullable = false,updatable = false)
	private Student student;
}
