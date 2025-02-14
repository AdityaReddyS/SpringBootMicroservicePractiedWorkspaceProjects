package com.shankar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.model.Employee;
import com.shankar.repo.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list=emprepo.findAll();
		return list;
	}

	@Override
	public String registerEmployeeInfo(Employee emp) {
		int idval=emprepo.save(emp).getEmpno();
		return "Employee is Saved With the ID Value is:::"+idval;
	}

	@Override
	public Employee updateEmployee(int id) {
	Employee emp=emprepo.getReferenceById(id);
		return emp;
	}
@Override
public String processUpdateEmployee(Employee emp) {
	
	return "Employee is updated :::"+emprepo.save(emp).getEmpno();
}
@Override
public String deleteEmployeeByNo(int no) {
	emprepo.deleteById(no);
	return no+"Employee is found and deleted";
}
}
