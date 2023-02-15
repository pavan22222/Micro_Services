package com.infinite.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table(name = "Person_Passport")
@NoArgsConstructor
public class PassPort {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passport_id")
	private Integer passportId;
	@Column(name = "passport_name",length = 30)
	private String  passportName;
	@Column(name="date_of_expired")
	@javax.persistence.Temporal(TemporalType.DATE)
	private Date doe;
	@OneToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
	@JoinColumn(name = "person_id",referencedColumnName = "person_id")
	private Person person;
	
	
	

}
