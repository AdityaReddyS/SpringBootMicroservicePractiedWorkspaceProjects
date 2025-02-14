package com.shankar.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/billing")
@Slf4j
public class BillingController {
	@Value("${server.port}")
	private int port;
	@Value("${eureka.instance.instance-id}")
	private String instanceid;
	@GetMapping("/info")
	public ResponseEntity<String> fetchingBillDetails(){
		log.info("Rest controller started for executing before the method");
		log.info("Rest controller started for executing after the method");
		return new ResponseEntity<String>("Final Bill Amount=BillAmount-discount(Rs 5000)::using instance::->"+instanceid+"---port---"+port,HttpStatus.OK);
		
	}

}
