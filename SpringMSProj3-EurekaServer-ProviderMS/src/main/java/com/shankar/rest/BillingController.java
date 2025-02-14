package com.shankar.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingController {
	
	@GetMapping("/info")
	public ResponseEntity<String> showShoppingInfo(){
		return new ResponseEntity<String>("We Accept All Types Of Payments UPI,GPay,NetBanking,COD",HttpStatus.OK);
	}

}
