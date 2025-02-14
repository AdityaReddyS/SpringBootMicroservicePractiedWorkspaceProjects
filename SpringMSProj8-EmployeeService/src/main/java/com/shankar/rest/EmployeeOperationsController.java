package com.shankar.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@RefreshScope
public class EmployeeOperationsController {
	@Value("${dbuser}")
	private String username;
	@Value("${dbpwd}")
	private String password;
	
	@GetMapping("/show")
	public String showData() {
		return "Data Collected from Config server------>"+username+"---------password="+password;
					}

}
