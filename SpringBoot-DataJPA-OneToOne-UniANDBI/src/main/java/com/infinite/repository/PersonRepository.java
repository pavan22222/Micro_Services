package com.infinite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
