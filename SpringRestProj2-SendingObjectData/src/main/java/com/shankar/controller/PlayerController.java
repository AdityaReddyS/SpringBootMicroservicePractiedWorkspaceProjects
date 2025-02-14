package com.shankar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.entity.Player;
@RestController
@RequestMapping("/playerinfo")
public class PlayerController {
	
	@GetMapping("/report")
	public ResponseEntity<Player> showplayerInfo(){
		
		Player play=new Player(1001,"shankar","csk",15500.0);
		return new ResponseEntity<Player>(play,HttpStatus.OK);
	}

}
