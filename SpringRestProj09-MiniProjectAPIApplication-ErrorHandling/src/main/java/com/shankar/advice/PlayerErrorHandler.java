package com.shankar.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shankar.entity.ErrorDetails;
import com.shankar.exception.PlayerNotFoundException;

@RestControllerAdvice
public class PlayerErrorHandler {
	
	@ExceptionHandler(PlayerNotFoundException.class)
	public ResponseEntity<ErrorDetails> PlayerNotFoundError(PlayerNotFoundException pnf){
		System.out.println("PlayerErrorHandler.PlayerNotFoundError()");
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),pnf.getMessage(),"404-Player Not Found");
		return new  ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> HandleAllExceptions(Exception e){
		System.out.println("PlayerErrorHandler.PlayerNotFoundError()");
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(),e.getMessage(),"Internal Server Error");
		return new  ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
