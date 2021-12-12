package com.vrnda.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vrnda.model.Employee;

@RestController
public class EmployeeController {
	
	
	
	public EmployeeController() {
		System.out.println("EmployeeController.EmployeeController()");
	}

	@GetMapping("/getEmployee")
	public Employee getEmployee() {
		return new Employee(1,"Pavan","Developer",12000d,new String[] {"Reading","Playing"},List.of("Java", "Devops"),Set.of(8374293058l,7780110665l),Map.of("HYd", "SR Nagar"));
	}
	
	@PostMapping("/insertEmployee")
	public String insertEmployee(@RequestBody Employee emp) {
		System.out.println(emp);
		return "insertEmployee Post Http Method "+emp;
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee() {
		return "updateEmployee Put Http Method";
	}
	
	@PatchMapping("/updateEmployeeName")
	public String updateEmployeeName() {
		return "updateEmployeeName Patch Http Method";
	}
	
	@DeleteMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam Integer id) {
		return "deleteEmployee Delete Http Method "+id;
	}

}
