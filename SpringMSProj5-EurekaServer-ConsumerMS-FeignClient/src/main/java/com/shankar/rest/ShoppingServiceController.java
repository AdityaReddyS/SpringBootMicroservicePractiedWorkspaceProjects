package com.shankar.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.client.BillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingServiceController {
	@Autowired
	private BillingServiceRestConsumer consumer;
	
	@GetMapping("/cart")
	public ResponseEntity<String> showShoppingInfo(){
		String resultBody=consumer.getBillingInfo();
		System.out.println("client component class name"+consumer.getClass().getSuperclass());
		return new ResponseEntity<String>("Shopping the Items(Shirt,trouser,Pant):::::::"+resultBody,HttpStatus.OK);
	}

}
