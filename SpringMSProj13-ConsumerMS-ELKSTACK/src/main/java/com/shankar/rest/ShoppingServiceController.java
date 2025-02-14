package com.shankar.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.client.BillingServiceRestConsumer;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/shopping-api")
@Slf4j
public class ShoppingServiceController {
	@Autowired
	private BillingServiceRestConsumer consumer;
	
	@GetMapping("/details")
	public ResponseEntity<String> showShoppingInfo(){
		log.info("method started for execution");
		String resultBody=consumer.getBillingInfo();
		log.info("processing the method");
		log.info("method is executed");
		return new ResponseEntity<String>("Shopping the Items(Shirt,trouser,Pant):::::::"+resultBody,HttpStatus.OK);
	}

}
