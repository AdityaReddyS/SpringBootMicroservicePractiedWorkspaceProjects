package com.shankar.controller;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHome() {
		//ses.setMaxInactiveInterval(90);
		return "welcome";
	}
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	@GetMapping("/balance")
	public String showBalance(Map<String,Object> map) {
		map.put("balance", new Random().nextInt(200000));
		return "balance";
	}
	@GetMapping("/loanapprove")
	public String loanApprove(Map<String,Object> map) {
		map.put("amount", new Random().nextInt(200000));
		return "loanapprove";
	}
	
	@GetMapping("/access-denied")
	public String accesDenied() {
		return "accessdenied";
	}
	
}
