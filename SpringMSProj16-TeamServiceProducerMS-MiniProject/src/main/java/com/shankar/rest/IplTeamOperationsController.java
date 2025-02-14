package com.shankar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.entity.IPLTeam;
import com.shankar.service.IplTeamService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/team-api")
@Slf4j
public class IplTeamOperationsController {
	@Autowired
	private IplTeamService teamService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTeam(@RequestBody IPLTeam team){
		//use service
		try {
			String resultMsg=teamService.registerIPLTeam(team);
			log.info("registerTeam method -- controller ");
			return new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);
		}
		catch(Exception e) {
			log.error("problem in registerTeam method -- controller ::"+e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}//method
	
	@GetMapping("/all")
	public  ResponseEntity<?>   showAllTeams(){
		try {
			//use service
			 List<IPLTeam> list=teamService.getAllTeams();
				log.info("showAllTeams() method -- controller ");
			 return  new ResponseEntity<List<IPLTeam>>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			log.error("problem in showAllTeams method -- controller ::"+e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//method
	
	@GetMapping("/find/{id}")
	public  ResponseEntity<?>  showTeamById(@PathVariable int id){
		try {
			//use service
			IPLTeam team=teamService.getTeamById(id);
			log.info("showByTeamId(-) method -- controller ");
			return new ResponseEntity<IPLTeam>(team,HttpStatus.OK);
		}
		catch(Exception e) {
			log.error("problem in showByTeamId(-) method -- controller:: "+e.getMessage());
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//method

}
