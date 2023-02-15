package com.infinite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinite.entity.JobSeeker;


public interface BottleRepository extends JpaRepository<JobSeeker, String> {
	
	

}
