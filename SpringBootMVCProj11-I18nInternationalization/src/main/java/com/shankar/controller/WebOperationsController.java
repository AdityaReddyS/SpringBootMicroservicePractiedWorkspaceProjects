package com.shankar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.model.Customer;

@Controller
public class WebOperationsController {
	
	@RequestMapping("/")
public String showHome() {
	System.out.println("WebOperationsController.showHome()");
	return "welcome";
}
	@RequestMapping("/customformtags")
	public String showJSTLInformationsUsingI18N() {
	System.out.println("WebOperationsController.showJSTLInformationsUsingI18N()");
		return "form";
	}
	@GetMapping("/register")
	public String processCustomer(@ModelAttribute("cust") Customer cust) {
		System.out.println("WebOperationsController.processCustomer()");
		return "register_form";
	}
}
