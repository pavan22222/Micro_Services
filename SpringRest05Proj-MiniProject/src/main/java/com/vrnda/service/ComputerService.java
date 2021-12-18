package com.vrnda.service;

import java.util.List;

import com.vrnda.entity.Computers;
import com.vrnda.exception.ComputerNotFoundException;

public interface ComputerService {
	String saveComputer(Computers computer);
	Computers getComputers(Long id) throws ComputerNotFoundException;
	List<Computers> getAllComputers() ;
	String updateComputer(Computers computer)throws ComputerNotFoundException;
	String deleteComputer(Long id)throws ComputerNotFoundException;
}
