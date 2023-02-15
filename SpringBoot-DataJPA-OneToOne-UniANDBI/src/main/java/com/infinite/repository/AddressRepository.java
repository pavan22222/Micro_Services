package com.infinite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.entity.Address;

public interface AddressRepository extends JpaRepository<Address, String> {

}
