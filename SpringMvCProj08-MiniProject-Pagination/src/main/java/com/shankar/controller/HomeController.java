package com.shankar.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shankar.model.Employee;
import com.shankar.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private EmployeeService service;
	
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
	@GetMapping("/report-pagination")
	public String getEmployeereportByPagination(Map<String,Object> map,
			                                                        @PageableDefault(page = 0,size = 3,sort = "job",direction = Sort.Direction.ASC)Pageable pageable) {
		System.out.println("HomeController.getEmployeereportByPagination()");
		Page<Employee> page=service.getEmployeeReportByPage(pageable);
		map.put("pagesData",page);
		return "report_pagination";
	}
	
	@GetMapping("/register")
	public String registerEmployee(@ModelAttribute("empl") Employee emp) {
		return "register_form";
	}
	@PostMapping("/register")
	public String processTheEmployee(@ModelAttribute("empl") Employee emp,HttpSession ses) {
		System.out.println("HomeController.processTheEmployee()");
		String msg=service.registerEmployeeInfo(emp);
		
		ses.setAttribute("resultMsg", msg);
		return "redirect:report";
	}
	@GetMapping("/edit")
	public String EditEmployee(@RequestParam("no") int no,@ModelAttribute("empl") Employee emp) {
		Employee emp1=service.updateEmployee(no);
		BeanUtils.copyProperties(emp1, emp);
		return "edit_employee";
	}
	@PostMapping("/edit")
	public String updateEmployee(@ModelAttribute("empl") Employee emp,RedirectAttributes attrs) {
		System.out.println("HomeController.processTheEmployee()");
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
