package com.shankar.rest;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/ticket")
public class TicketBookingOperationsController {
	
	@GetMapping("/book")
	@HystrixCommand(fallbackMethod = "dummybookTicket")
	public ResponseEntity<String> bookTicket(){
		System.out.println("TicketBookingOperationsController.bookTicket()");
		if(new Random().nextInt(10)<5)
			throw new RuntimeException("Problem in the B.logic");
		return new ResponseEntity<String>("Output Executed from the B.logic",HttpStatus.OK);
	}

public ResponseEntity<String> dummybookTicket(){
		System.out.println("TicketBookingOperationsController.dummybookTicket()");
		return new ResponseEntity<String>("Please Try Later--Inconvience Regretted",HttpStatus.OK);
	}
}
