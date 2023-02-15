package com.infinite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer>{

}
