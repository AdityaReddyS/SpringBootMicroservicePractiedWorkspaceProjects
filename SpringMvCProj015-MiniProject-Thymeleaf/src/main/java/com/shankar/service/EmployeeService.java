package com.shankar.service;

import com.shankar.model.Employee;

public interface EmployeeService {
	
	public Iterable<Employee> getAllEmployees();
	
	public String registerEmployeeInfo(Employee emp);
	public Employee updateEmployee(int id);
	public String processUpdateEmployee(Employee emp);
	public String deleteEmployeeByNo(int no);

}
