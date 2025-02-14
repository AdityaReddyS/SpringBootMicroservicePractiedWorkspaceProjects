package com.shankar.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerOperationsController {
	@Value("${dbuser}")
	private String username;
	@Value("${dbpwd}")
	private String password;
	
	@GetMapping("/display")
	public String showData() {
		return "Data Collected from Config server(customer)----->"+username+"---------password="+password;
					}

}
