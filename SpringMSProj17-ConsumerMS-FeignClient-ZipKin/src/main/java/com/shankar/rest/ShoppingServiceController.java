package com.shankar.rest;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.SpringMsProj17EurekaServerConsumerMicroServiceApplication;
import com.shankar.client.BillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingServiceController {
	private Logger logger=LoggerFactory.getLogger(SpringMsProj17EurekaServerConsumerMicroServiceApplication.class);

	@Autowired
	private BillingServiceRestConsumer consumer;
	
	@GetMapping("/cart")
	public ResponseEntity<String> showShoppingInfo(){
		logger.info("before calling the method ");
		logger.info("method invocation");
		String resultBody=consumer.getBillingInfo();
		System.out.println("client component class name"+consumer.getClass().getSuperclass());
		logger.info("geting the response body");
		return new ResponseEntity<String>("Shopping the Items(Shirt,trouser,Pant):::::::"+resultBody,HttpStatus.OK);
	}

}
