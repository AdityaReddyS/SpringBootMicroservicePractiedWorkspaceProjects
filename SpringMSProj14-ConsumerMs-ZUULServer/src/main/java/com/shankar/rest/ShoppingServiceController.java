package com.shankar.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${server.port}")
	private int port;
	@Value("${eureka.instance.instance-id}")
	private String instanceid;
	
	@GetMapping("/details")
	public ResponseEntity<String> showShoppingInfo(){
		String resultBody=consumer.getBillingInfo();
		
		return new ResponseEntity<String>("Shopping the Items(Shirt,trouser,Pant):::::::-->Instance Id::"+instanceid+"port-->"+port+" Result"+resultBody,HttpStatus.OK);
	}

}
