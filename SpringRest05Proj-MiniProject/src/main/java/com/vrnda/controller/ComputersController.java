package com.vrnda.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vrnda.entity.Computers;
import com.vrnda.service.ComputerService;

@RestController
public class ComputersController {
	private static Logger logger=Logger.getLogger(ComputersController.class);
	@Autowired
	private ComputerService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> enrollComputer(@RequestBody Computers compoter){
		try {
			logger.debug("enrollComputer");
			String retMsg=service.saveComputer(compoter);
			return new ResponseEntity<String> (retMsg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String> ("Internal Problem", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?>  getComputer(@PathVariable Long id){
		try {
			return new ResponseEntity<Computers>(service.getComputers(id),HttpStatus.OK);
		}catch (Exception e) {
			logger.fatal(e);
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<?>  displayAllComputers(){
		try {
			List<Computers> listComputers=service.getAllComputers();
			return listComputers != null && listComputers.size() > 0?new  ResponseEntity<List<Computers>>(listComputers.stream().sorted((a,b) -> - a.getHardwareId().compareTo(b.getHardwareId())).collect(Collectors.toList()),HttpStatus.OK):
				new ResponseEntity<String>("No Employees Found",HttpStatus.OK);
		}catch (Exception e) {
			logger.fatal(e);
			return new ResponseEntity<String>("Internal Problem",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//@PostMapping("/update")
	@RequestMapping(value="/update",method = {RequestMethod.PATCH,RequestMethod.PUT})
	public ResponseEntity<String> updateComputer(@RequestBody Computers compoter){
		try {
			logger.debug("updateComputer");
			String retMsg=service.updateComputer(compoter);
			return new ResponseEntity<String> (retMsg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String> (e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteComputer(@PathVariable Long id){
		try {
			logger.debug("updateComputer");
			String retMsg=service.deleteComputer(id);
			return new ResponseEntity<String> (retMsg, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String> (e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
