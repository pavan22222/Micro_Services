package com.vrnda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrnda.entity.Computers;
import com.vrnda.exception.ComputerNotFoundException;
import com.vrnda.repository.ComputersRepository;
@Service
public class ComputerServiceImpl  implements ComputerService{
	
	@Autowired
	private ComputersRepository repository;
	
	@Override
	public String saveComputer(Computers computer) {
		Long id= repository.save(computer).getHardwareId();
		return "Computer is Manufactured With the Haedware Id::"+id;
	}
	
	@Override
	public Computers  getComputers(Long id) throws ComputerNotFoundException{
		/*Optional<Computers> opt= repository.findById(id);
		Computers retObj=null;
		if(opt.isPresent()) {
			retObj= opt.get();
		}else {
			throw new ComputerNotFoundException("Invalid Id");
		}
		return retObj;*/
		return repository.findById(id).orElseThrow(()-> new ComputerNotFoundException("Invalid Id") );
	}

	@Override
	public List<Computers> getAllComputers() {
		return repository.findAll();
	}

	@Override
	public String updateComputer(Computers computer) throws ComputerNotFoundException{
		Optional<Computers> optional=repository.findById(computer.getHardwareId());
		if(optional.isPresent()) {
			return repository.save(computer).getHardwareId()+" is Updated";
		}else 
			 throw new ComputerNotFoundException("Hardware ID Not Found");
	}

	@Override
	public String deleteComputer(Long id) throws ComputerNotFoundException {
		Optional<Computers> optional=repository.findById(id);
		if(optional.isPresent()) {
			repository.deleteById(id);
			return id+" is Deleted";
		}else 
			 throw new ComputerNotFoundException("Hardware ID Not Found");
	}
}
