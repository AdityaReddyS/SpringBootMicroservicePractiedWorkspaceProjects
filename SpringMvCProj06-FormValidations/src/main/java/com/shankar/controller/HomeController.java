package com.shankar.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shankar.model.Employee;
import com.shankar.service.EmployeeService;
import com.shankar.validator.EmployeeValidator;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeValidator validator;
	
	@RequestMapping("/")
	public String welcome() {
		return "welcome";
	}
	@GetMapping("/report")
 public String getallEmployeesReport(Map<String,Object> map) {
		System.out.println("HomeController.getallEmployeesReport()");
		Iterable<Employee> emplist=service.getAllEmployees();
	 map.put("empsInfo",emplist );
	 return "show_report";
 }
	
	@GetMapping("/register")
	public String registerEmployee(@ModelAttribute("emp") Employee emp) {
		return "register_form";
	}
	@PostMapping("/register")
	public String processTheEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attrs,BindingResult errors) {
		if(emp.getVflag1().equalsIgnoreCase("no")) {
		System.out.println("HomeController.processTheEmployee()");
		//use validator
		if(validator.supports(Employee.class)) {
			validator.validate(emp, errors);
			//application logic errors
			if(service.isDesignationReject(emp.getJob()))
				errors.rejectValue("job", "emp.desg.reject");
			
			if(errors.hasErrors())
				return "register_form";
		}
		}
		String msg=service.registerEmployeeInfo(emp);
		
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:report";
	}
	@GetMapping("/edit")
	public String EditEmployee(@RequestParam("no") int no,@ModelAttribute("emp") Employee emp) {
		Employee emp1=service.updateEmployee(no);
		BeanUtils.copyProperties(emp1, emp);
		return "edit_employee";
	}
	@PostMapping("/edit")
	public String updateEmployee(@ModelAttribute("emp") Employee emp,RedirectAttributes attrs,BindingResult errors) {
		if(emp.getVflag1().equalsIgnoreCase("no")) {
		System.out.println("HomeController.processTheEmployee()");
		if(validator.supports(Employee.class)) {
			validator.validate(emp, errors);
			//application logic errors
			if(service.isDesignationReject(emp.getJob()))
				errors.rejectValue("job", "emp.desg.reject");
			if(errors.hasErrors())
				return "edit_employee";
		}
		}
		//using service
		String msg=service.processUpdateEmployee(emp);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
		
	}
	@GetMapping("/delete")
	public String deleteEmployeeById(@RequestParam("no") int no,RedirectAttributes attrs) {
		//using service
				String msg=service.deleteEmployeeByNo(no);
				attrs.addFlashAttribute("resultMsg",msg);
				return "redirect:report";
	}
}
