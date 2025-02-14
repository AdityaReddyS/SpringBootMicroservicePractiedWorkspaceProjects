package com.shankar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.model.Employee;
import com.shankar.service.EmployeeMgmtService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeOperationsController {
	
@Autowired
	private EmployeeMgmtService service;

@PostMapping("/save")
public Mono<Employee> saveEmployee(@RequestBody Employee emp){
	System.out.println("EmployeeOperationsController.saveEmployee()"+emp.hashCode());
	return service.saveEmployee(emp);
}

@GetMapping("/all")
public Flux<Employee> getAllEmployees(){
	System.out.println("EmployeeOperationsController.getAllEmployees()");
	return service.getallEmployee();
}
@GetMapping("/findbyid/{id}")
public Mono<Employee> getEmployeeById(@PathVariable("id") int id){
	System.out.println("EmployeeOperationsController.getEmployeeById()");
	return service.getEmployeeById(id);
}

@GetMapping("/deletebyid/{id}")
public Mono<Void> removeEmployee(@PathVariable("id") int id){
	System.out.println("EmployeeOperationsController.removeEmployee()");
	return service.removeEmployee(id);
}
}
