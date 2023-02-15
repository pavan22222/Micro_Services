package com.infinite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infinite.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer>{
	
	@Query("select ph from Phone ph inner join ph.phoneNumbers where ph.phoneName is not null")
	//@Query("select ph from Phone ph left join ph.phoneNumbers where ph.phoneName is not null")
	//@Query("select ph from Phone ph right join ph.phoneNumbers where ph.phoneName is not null")
	//@Query("select ph from Phone ph full join ph.phoneNumbers where ph.phoneName is not null")
	List<Phone> getPhones();

}
