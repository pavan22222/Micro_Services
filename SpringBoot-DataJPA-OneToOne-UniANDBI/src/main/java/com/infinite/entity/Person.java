package com.infinite.entity;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
public class Person {
	
	@Id
	@SequenceGenerator(name = "personSequence",sequenceName = "Person_Sequence",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "personSequence",strategy = GenerationType.SEQUENCE )
	@Column(name="person_id")
	private Long personId;
	@Column(name = "person_name",length = 30)
	private String personName;
	@OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true,mappedBy = "person")
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Fetch(FetchMode.JOIN)
	private Set<Address> addresses;
	@OneToOne(targetEntity = PassPort.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true,mappedBy = "person")
	private PassPort passPort;

}
