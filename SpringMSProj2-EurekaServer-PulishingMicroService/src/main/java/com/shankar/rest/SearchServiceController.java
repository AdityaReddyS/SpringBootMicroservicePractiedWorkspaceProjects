package com.shankar.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search-api")
public class SearchServiceController {
	
	@GetMapping("/show")
	public ResponseEntity<String> showShoppingInfo(){
		return new ResponseEntity<String>("Welcome to Shopping Service",HttpStatus.OK);
	}

}
