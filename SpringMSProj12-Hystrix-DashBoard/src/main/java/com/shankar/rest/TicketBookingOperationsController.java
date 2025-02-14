package com.shankar.rest;

import java.util.Random;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("/ticket")
public class TicketBookingOperationsController {
	 int count=0;
	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "dummybookTicket",
	commandProperties = {@HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="5"),
			@HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),
			@HystrixProperty(name="circuitBreaker.enabled",value="true")})
	public ResponseEntity<String> bookTicket(){
		System.out.println("TicketBookingOperationsController.bookTicket()");
		if(new Random().nextInt(10)<8)
			throw new RuntimeException("Problem in the B.logic");
		return new ResponseEntity<String>("Output Executed from the B.logic",HttpStatus.OK);
	}

public ResponseEntity<String> dummybookTicket(){
	count++;
		System.out.println("TicketBookingOperationsController.dummybookTicket()--"+count);
		return new ResponseEntity<String>("Please Try Later--Inconvience Regretted",HttpStatus.OK);
	}
}
