package com.shankar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

	@GetMapping("/")
	 public String  showLauchingPage() {
		 return "redirect:/bank/";
	 }
}
