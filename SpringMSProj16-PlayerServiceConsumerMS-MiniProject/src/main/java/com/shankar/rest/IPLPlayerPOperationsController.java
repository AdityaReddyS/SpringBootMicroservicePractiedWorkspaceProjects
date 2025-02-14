//IPLPlayerPOperationsController .java
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

import com.shankar.clientcomp.IPLTeamServiceMSClient;
import com.shankar.entity.IPLPlayer;
import com.shankar.entity.IPLTeam;
import com.shankar.service.IPLPlayerMgmtService;



@RestController
@RequestMapping("/player-api")
public class IPLPlayerPOperationsController {
	@Autowired
	private  IPLPlayerMgmtService playerService;
	@Autowired
	private   IPLTeamServiceMSClient  client;
	
	@PostMapping("/save")
	public  ResponseEntity<String> registerPlayer(@RequestBody IPLPlayer player){
		  //get Player's team id  
		 int tid=player.getTeam().getTeamId();
		// get IPLTeam object from Target MS (IPLTeamMs)
		IPLTeam team=client.getTeamById(tid);  // (MicroServices intra communication)
		//set Team object to Player object
		player.setTeam(team);
		try {
		//use serivce
		 String msg=playerService.registerPayer(player);
		 return  new ResponseEntity<String>(msg , HttpStatus.CREATED);
		}
		catch(Exception e) {
			 return  new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//method
	
	@GetMapping("/all")
	public   ResponseEntity<?>   showAllPlayers(){
		try {
			//use service
			List<IPLPlayer> list=playerService.findAllPlayers();
			return  new ResponseEntity<List<IPLPlayer>>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//method
	
	@GetMapping("/find/{id}")
	public    ResponseEntity<?>  showPlayerById(@PathVariable int id){
		try {
			//use service
			IPLPlayer player=playerService.findPlayerById(id);
			return  new ResponseEntity<IPLPlayer>(player,HttpStatus.OK);
		}
		catch(Exception e) {
			return  new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}//method

}
