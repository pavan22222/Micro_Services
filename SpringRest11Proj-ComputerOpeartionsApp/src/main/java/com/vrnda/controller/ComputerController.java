package com.vrnda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.vrnda.beans.Computer;
import com.vrnda.service.IComputerService;

@Controller
@PropertySource("classpath:com/vrnda/commons/rest.properties")
public class ComputerController {
	@Autowired
	private IComputerService service;
	
	
	@GetMapping()
	public String homeHandler() {
		return "home";
	}
	
	@GetMapping("/getAllComputers")
	public String getAllComputers(Model model) throws Exception {
		try {
			List<Computer> list = service.retrieveAllComputers();
			if (list != null && list.size() > 0)
				model.addAttribute("list", list);

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("list", "Internal Error");
		}
		return "list_computer";
	}
	
}
