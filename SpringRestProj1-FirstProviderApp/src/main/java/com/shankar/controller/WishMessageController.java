package com.shankar.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish-api")
public class WishMessageController {
	
@GetMapping("/welcome")
	public ResponseEntity<String> showMessage(){
		//generate system date
	LocalDateTime ldt=LocalDateTime.now();
	int hour=ldt.getHour();
String msg=null;
if(hour<12)
	msg= "Good Morning";
else if(hour<16)
	msg= "Good Afternoon";
else if(hour<20)
	msg= "Good Evening";
	else 
		msg= "Good Night";
return new ResponseEntity<String>(msg,HttpStatus.OK);
}


}
