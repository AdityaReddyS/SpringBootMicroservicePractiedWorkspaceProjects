package com.shankar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.entity.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationsController {
@GetMapping("/wish")
	public ResponseEntity<String> showMessage(){
		return new ResponseEntity<String>("Good Evening Shankar Reddy",HttpStatus.OK);
	}

@GetMapping("/wish/{id}/{name}")
public ResponseEntity<String> showMessage1(@PathVariable Integer id,@PathVariable String name){
	return new ResponseEntity<String>("Good Evening Shankar Reddy"+id+"...."+name,HttpStatus.OK);
}

@PostMapping("/wish/register")
public ResponseEntity<String> showActorinfo(@RequestBody Actor actor){
	return new ResponseEntity<String>(actor.toString(),HttpStatus.OK);
}

@GetMapping("/wish/report")
public ResponseEntity<?> showReport(){
	List<Actor> actor=List.of(new Actor(1001,"shankar","hyderabad",256367.0),
			new Actor(1001,"shankar","hyderabad",256367.0),
			new Actor(1001,"shankar","hyderabad",256367.0));
	return new ResponseEntity<List<Actor>>(actor,HttpStatus.OK);
}

@GetMapping("/wish/find")
public ResponseEntity<?> findActor(){
	Actor actor=new Actor(1001,"shankar","hyderabad",256367.0);
	return new ResponseEntity<Actor>(actor,HttpStatus.OK);
}

}
