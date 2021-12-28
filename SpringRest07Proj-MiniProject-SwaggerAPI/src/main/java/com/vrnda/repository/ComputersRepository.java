package com.vrnda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vrnda.entity.Computers;

public interface ComputersRepository extends JpaRepository<Computers, Long> {

}
