package com.shankar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shankar.model.Employee;
import com.shankar.service.EmployeeServiceMgmt;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeServiceMgmt service; 
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
@GetMapping("/report")
	public String fetchAllStudents(Map<String,Object> map,@RequestParam("type") String type) {
		//use service
	Iterable<Employee> empsList=service.getAllEmployees();
	//add to model attribute
	map.put("empsList", empsList);
	//return lvn
	if(type.equals("pdf"))
		return "pdfreport";
	else
		return "excelreport";
	}
}
