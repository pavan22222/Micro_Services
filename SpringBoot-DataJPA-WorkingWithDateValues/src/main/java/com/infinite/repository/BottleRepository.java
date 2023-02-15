package com.infinite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infinite.entity.Bottle;


public interface BottleRepository extends JpaRepository<Bottle, String> {
	
	@Query(nativeQuery = true,value = "update Bottle set price=:price where id=:id")
	@Modifying
	int updateBottle(@Param("price") Float price,String id);

}
