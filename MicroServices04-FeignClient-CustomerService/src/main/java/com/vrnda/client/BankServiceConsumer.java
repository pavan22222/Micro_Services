package com.vrnda.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.vrnda.dto.Customer;

@FeignClient("Bank-Service")
public interface BankServiceConsumer {
	@GetMapping("bank/getInfo1")
	public String getInfo();
	
	@GetMapping("/bank/getInfo")
	public List<Customer> getCustomers();	
	
	@GetMapping("/bank/saveCustomer")
	public String saveCustomer(Customer customer);	
}
