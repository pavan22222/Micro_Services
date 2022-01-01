package com.vrnda.service;

import java.util.List;

import com.vrnda.beans.Computer;

public interface IComputerService {
	List<Computer> retrieveAllComputers() throws Exception;
}
