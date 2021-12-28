package com.vrnda.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vrnda.entity.Computer;

@RestController
@RequestMapping("/computer")
public class ComputersController {
	private static Logger logger=Logger.getLogger(ComputersController.class);
	
	@GetMapping("getComputerName")
	public ResponseEntity<String> getComputerCompanyName(){
		return new ResponseEntity<String>("My  Computer Company NAme is HP",HttpStatus.OK);
	}
	
	@GetMapping("getComputerDetails/{computerName}")
	public ResponseEntity<String> getComputerDetails(@PathVariable String computerName){
		return new ResponseEntity<String>("My  Computer Name is"+computerName+" Having Ram 16GB,1TB Hard Disk",HttpStatus.OK);
	}
	
	@PostMapping("/save/{name}")
	public ResponseEntity<Computer> saveComputer(@RequestBody Computer computer,@PathVariable String name){
		System.out.println(name);
		return new ResponseEntity<Computer>(computer,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Computer>> getAll(){
		return new ResponseEntity<List<Computer>>(List.of(new Computer("HP", "2 GB", "", "", 45000d,new Date()), new Computer("DELL", "4 GB", "", "", 56000d,  new Date())),HttpStatus.CREATED);
	}

}
