package com.shankar.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shankar.model.Student;

@Controller
public class DataRenderingController {
	@RequestMapping("/")
	public String showHome() {
		System.out.println("DataRenderingController.showHome()");
		return "/welcome";
	}
	@GetMapping("/register")
	public String registerStudent() {
		System.out.println("DataRenderingController.registerStudent()");
		return "/student_register";
	}
	
	@PostMapping("/register")
	public String processStudent(Map<String,Object> map,@ModelAttribute("stud") Student st) {
	System.out.println(st);
		System.out.println("DataRenderingController.registerStudent()");
		return "/show_result";
	}
}
