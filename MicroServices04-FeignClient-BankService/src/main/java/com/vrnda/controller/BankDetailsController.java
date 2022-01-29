package com.vrnda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vrnda.dto.Customer;

@RestController
@RequestMapping("/bank")
public class BankDetailsController {
	
	@Value("${server.port}")
	private Integer port;
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	
	@GetMapping("/getInfo")
	public ResponseEntity<List<Customer>> getInfo() {
		List<Customer> list=List.of(new Customer(),new Customer());
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getInfo1")
	public String getInfo1() {
		return "You have account in Bank ...... port number is "+port+" instance id is:"+instanceId;
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustmer(@RequestBody Customer customer) {
		return "your details are registered"+customer;
	}

}
