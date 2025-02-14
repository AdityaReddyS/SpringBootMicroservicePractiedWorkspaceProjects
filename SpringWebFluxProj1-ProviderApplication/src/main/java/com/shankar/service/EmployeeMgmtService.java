package com.shankar.service;

import com.shankar.model.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeMgmtService {
	public Mono<Employee> saveEmployee(Employee emp);
	public Flux<Employee> getallEmployee();
	public Mono<Employee> getEmployeeById(Integer id);
	public Mono<Void> removeEmployee(Integer id);

}
