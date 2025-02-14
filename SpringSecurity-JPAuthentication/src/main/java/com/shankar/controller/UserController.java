package com.shankar.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.model.UserInfo;
import com.shankar.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
	private IUserService service;


@GetMapping("/showLogin")
public String showLoginPage() {
	return "custom_login";
}
	@GetMapping("/register")
	private String showUserFormPage(@ModelAttribute("userInfo") UserInfo user) {
		return "user_register";
	}
	@PostMapping("/register")
	public String processUser(Map<String,Object> map,@ModelAttribute("userInfo") UserInfo user) {
		//user service
		String resultMsg=service.registerUser(user);
		map.put("message", resultMsg);
		return "user_registered_success";
	}
	
}
