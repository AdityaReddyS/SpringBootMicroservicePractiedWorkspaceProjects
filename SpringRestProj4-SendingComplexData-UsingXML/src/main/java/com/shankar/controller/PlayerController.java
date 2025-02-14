package com.shankar.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.entity.Player;
import com.shankar.entity.Team;
@RestController
@RequestMapping("/playerinfo")
public class PlayerController {
	
	@GetMapping("/report")
	public ResponseEntity<Player> showplayerInfo(){
		
		Player play=new Player(1001,"shankar","csk",15500.0,
				new String[] {"red","green","blue","orange"},
				List.of("bunny","chinnu","chotu","nani"),
				Set.of(12345678L,9876543210L,9949537276L,9505821965L),
				Map.of("adharNumber",123456789,"voterid Number",234567891,"driving license",884658411),
				new Team(10010,"Chennai",16,"KashiNath")
				);
		return new ResponseEntity<Player>(play,HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<String> showplayerInfo(@RequestBody Player play){
		
	
		return new ResponseEntity<String>(play.toString(),HttpStatus.OK);
	}
}
