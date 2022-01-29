package com.vrnda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vrnda.client.BankServiceConsumer;
import com.vrnda.dto.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private BankServiceConsumer consumer;
	
	@GetMapping("getBankDetails/{username}/{password}")
	public String getBankDetails(@PathVariable String username,@PathVariable String password) {
		return consumer.getInfo();
	}
	
	@GetMapping("/getCustomerDetails")
	public List<Customer> getCustomerDetails() {
		return consumer.getCustomers();
	}
	
	@GetMapping("/saveCustomer")
	public String saveCustomer(@RequestBody Customer customer) {
		return consumer.saveCustomer(customer);
	}
}
