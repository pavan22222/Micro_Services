package com.infinite.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table()
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {
	
	@javax.persistence.Id
	@GenericGenerator(name = "jobSeekerIdGenerator",strategy = "com.infinite.generators.JobSeekerIDGenerator")
	@javax.persistence.GeneratedValue(generator = "jobSeekerIdGenerator")
	private String id;
	@Column(name="name",length = 30)
	private String name;
	@Column(scale = 2)
	private Integer age;
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_passed_out")
	private Date dop;
	@Lob
	@Column(name="photo")
	private byte[] photo;
	@Lob
	@Column(name="resume",columnDefinition = "NVARCHAR(MAX)")
	@Type(type = "org.hibernate.type.descriptor.sql.NVarcharTypeDescriptor")
	private char[] resume;

}
