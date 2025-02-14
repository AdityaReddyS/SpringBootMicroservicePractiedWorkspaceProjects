package com.shankar.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shankar.model.Employee;
import com.shankar.service.EmployeeService;

@RestController
@RequestMapping("/emp-api")
public class HomeController {
	@Autowired
	private EmployeeService service;
	
	
	@GetMapping("/report")
 public ResponseEntity<?> getallEmployeesReport() {
		List<Employee> list=service.getAllEmployees();
	 return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
 }
	
	
	@PostMapping("/register")
	public ResponseEntity<String> SaveEmployee(@RequestBody Employee emp) {
		String msg=service.registerEmployeeInfo(emp);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	
	}
	
	@PutMapping("/edit") 
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp) {
	 
	  String msg=service.processUpdateEmployee(emp);

	  return new ResponseEntity<String>(msg,HttpStatus.OK);
	  
	  }
	/*
	 * @PostMapping("/edit") public String updateEmployee(@ModelAttribute("empl")
	 * Employee emp,RedirectAttributes attrs) {
	 * System.out.println("HomeController.processTheEmployee()"); //using service
	 * String msg=service.processUpdateEmployee(emp);
	 * attrs.addFlashAttribute("resultMsg",msg); return "redirect:report";
	 * 
	 * }
	 */
	@GetMapping("/delete/{no}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int no) {
		//using service
				String msg=service.deleteEmployeeByNo(no);
				 return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
