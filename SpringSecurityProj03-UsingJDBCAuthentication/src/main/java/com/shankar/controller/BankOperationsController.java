package com.shankar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BankOperationsController {
	@RequestMapping("/")
	public String showHome() {
		return "welcome";
	}
	@RequestMapping("/balance")
	public String showBalance() {
		return "balance";
	}
	@RequestMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	@RequestMapping("/loans")
	public String showPreapprovedLoans() {
		return "preapprovedloan";
	}
	@RequestMapping("/denied")
	public String ShowacessDeniedpage() {
		return "access_denied";
	}
}
