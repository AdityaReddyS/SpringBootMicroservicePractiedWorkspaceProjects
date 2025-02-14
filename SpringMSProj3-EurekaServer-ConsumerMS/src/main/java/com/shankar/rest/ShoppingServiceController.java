package com.shankar.rest;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.client.BillingServiceRestConsumer;

@RestController
@RequestMapping("/search-api")
public class ShoppingServiceController {
	@Autowired
	private BillingServiceRestConsumer consumer;
	
	@GetMapping("/details")
	public ResponseEntity<String> showShoppingInfo(){
		String resultBody=consumer.getBillingInfo();
		String binfo="bill Amount:::"+new Random().nextInt(12030);
		return new ResponseEntity<String>(binfo+"-----"+resultBody,HttpStatus.OK);
	}

}
