package com.shankar.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankOperationsController {

	
	@GetMapping("/")
	public  String showHome() {
		return "welcome";
	}
	
	@GetMapping("/balance")
	public   String showBalance(Map<String,Object> map) {
		map.put("bal", new Random().nextInt(100000));
		return  "show_balance";
	}
	
	@GetMapping("/offers")
	public   String showOffers() {
		return  "offers";
	}
	
	@GetMapping("/approve")
	public   String approveLoan(Map<String,Object> map) {
		map.put("amt", new Random().nextInt(1000000));
		return  "loan_approve";
	}
	
	@GetMapping("/denied")
	public   String  accessDenied() {
		return "access_denied";
	}
}
