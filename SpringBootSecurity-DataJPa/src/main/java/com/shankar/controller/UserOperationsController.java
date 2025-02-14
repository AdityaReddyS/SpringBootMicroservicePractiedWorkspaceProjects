package com.shankar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.entity.UserInfo;
import com.shankar.service.IUserDetailsMgmtService;

@Controller
@RequestMapping("/user")
public class UserOperationsController {
@Autowired
	private IUserDetailsMgmtService service;

@GetMapping("/showLogin")
public String showLoginPage() {
	return "custom_login";
}
	
	@GetMapping("/register")
	public String showregisteform(@ModelAttribute("userInfo") UserInfo user) {
		
		return "user_register";
	}
	@PostMapping("/register")
	public String registerUser(Map<String,Object> map,@ModelAttribute("userInfo") UserInfo user) {
		//call the service method
		String resultMsg=service.registerUser(user);
		map.put("message", resultMsg);
		return "user_registered_success";
	}
	
}
