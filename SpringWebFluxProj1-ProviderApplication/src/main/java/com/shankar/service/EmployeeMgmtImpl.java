package com.shankar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.model.Employee;
import com.shankar.repo.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service("empService")
public class EmployeeMgmtImpl implements EmployeeMgmtService {
	@Autowired
private EmployeeRepository emprepo;
	@Override
	public Mono<Employee> saveEmployee(Employee emp) {
		System.out.println("EmployeeMgmtImpl.saveEmployee()");
		return emprepo.save(emp);
	}

	@Override
	public Flux<Employee> getallEmployee() {
	System.out.println("EmployeeMgmtImpl.getallEmployee()");
		return emprepo.findAll().switchIfEmpty(Flux.empty());
	}

	@Override
	public Mono<Employee> getEmployeeById(Integer id) {
		System.out.println("EmployeeMgmtImpl.getEmployeeById()");
		return emprepo.findById(id).switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<Void> removeEmployee(Integer id) {
		System.out.println("EmployeeMgmtImpl.removeEmployee()");
		return emprepo.deleteById(id);
	}

}
