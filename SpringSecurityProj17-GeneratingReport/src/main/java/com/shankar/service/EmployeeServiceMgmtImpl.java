package com.shankar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.model.Employee;
import com.shankar.repo.EmployeeRepository;
@Service("empservice")
public class EmployeeServiceMgmtImpl implements EmployeeServiceMgmt {
@Autowired
	private EmployeeRepository emprepo;
	@Override
	public List<Employee> getAllEmployees() {
		return emprepo.findAll();
	}

	

}
