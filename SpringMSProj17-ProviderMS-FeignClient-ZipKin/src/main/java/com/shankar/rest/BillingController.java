package com.shankar.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingController {
	private Logger logger=LoggerFactory.getLogger(BillingController.class);
	@Value("${server.port}")
	private int port;
	@Value("${eureka.instance.instance-id}")
	private String instanceid;
	@GetMapping("/info")
	public ResponseEntity<String> fetchingBillDetails(){
		logger.info("at the begining of the method execution-Billing-Service");
		ResponseEntity<String> entity= new ResponseEntity<String>("Final Bill Amount=BillAmount-discount(Rs 5000)::using instance::->"+instanceid+"---port---"+port,HttpStatus.OK);
		logger.info("at the end of the method execution-Billing-Service");
	return entity;
	}

}
