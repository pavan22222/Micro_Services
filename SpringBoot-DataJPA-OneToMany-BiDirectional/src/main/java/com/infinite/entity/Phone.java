package com.infinite.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TemporalType;

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
@NoArgsConstructor
public class Phone {
	
	@Id
	@GenericGenerator(name = "phoneIdGenerator",strategy = "com.infinite.generators.PhoneIdGenerator")
	@GeneratedValue(generator = "phoneIdGenerator")
	@Column(name="phone_id")
	private Integer phoneId;
	@Column(name = "phone_name",length = 30)
	private String phoneName;
	@Column(name="price")
	private Float price;
	@javax.persistence.Temporal(TemporalType.DATE)
	private Date dom;
	@OneToMany(mappedBy = "phone",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	//@Fetch(FetchMode.JOIN)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<PhoneNumber> phoneNumbers;

}
