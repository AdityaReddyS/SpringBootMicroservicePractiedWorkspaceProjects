package com.shankar.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.model.Customer;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String welcome() {
		System.out.println("HomeController.showHomePage()");
		return "welcome";
	}
@GetMapping("/register")
	public String registerCustomer(@ModelAttribute("cust")Customer cust) {
		System.out.println("HomeController.registerCustomer()");
		return "register_form";
	}
@PostMapping("/register")
public String processTheCustomer(@ModelAttribute("cust")  Customer cust,Map<String,Object> map) {
	System.out.println("HomeController.processTheCustomer()");
	map.put("custData",cust);
	return "show_result";
}
@InitBinder
public void myDataInitBinder(WebDataBinder  binder) {
	System.out.println("HomeController.myDataInitBinder()");
	binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), true));
}
}
