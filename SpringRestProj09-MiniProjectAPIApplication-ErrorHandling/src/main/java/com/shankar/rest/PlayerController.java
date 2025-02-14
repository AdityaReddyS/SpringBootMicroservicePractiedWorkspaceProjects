package com.shankar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shankar.entity.Player;
import com.shankar.service.PlayerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/player-api")
@Tag(name="Player",description = "Player Information Api")
public class PlayerController {
	@Autowired
	private PlayerService service;
	
	@PostMapping("/save")
	@Operation(summary = "Save Operation",description = "Inserting Player into Data Base Table")
	@ApiResponses(value = {@ApiResponse(responseCode = "201",description = "Sucessful operation -CREATED")})
	public ResponseEntity<String> savePlayerInfo(@RequestBody Player player){
	
		String msg=service.savePlayer(player);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	@GetMapping("/preport")
	@Operation(summary = "Report Operation",description = "Fetching Data from Data Base Table")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Sucessful operation -OK")})
	public ResponseEntity<?> GetAllPlayersInfo(){
		
		List<Player> plist=service.getAllPayersInfo();
		return new ResponseEntity<List<Player>>(plist,HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{pid}")
	@Operation(summary = "Find Operation",description = "Fetching Data from Data Base Table")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Sucessful operation -OK")})
	public ResponseEntity<?> findplayerbyId(@PathVariable("pid") int pid) throws Exception{
		
		Player player=service.findPlayerByid(pid);
		return new ResponseEntity<Player>(player,HttpStatus.OK);
	
		
		
	}
	/*
	 * @GetMapping("/findplayer/{pname}") public ResponseEntity<?>
	 * findplayerbyName(@PathVariable("pname") String pname){ try { List<Player>
	 * player=service.findAllPlayersByName(pname); return new
	 * ResponseEntity<List<Player>>(player,HttpStatus.OK); } catch(Exception e) {
	 * return new
	 * ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
	
	@PutMapping("/update")
	@Operation(summary = "Update Operation",description = "Updating Player Information Into Data Base Table")
	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Sucessful operation -OK")})
	public ResponseEntity<String> updatePlayerInfo(@RequestBody Player player) throws Exception{
	
		String msg=service.updatePlayerDetails(player);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
		@PatchMapping("/pupdate/{id}/{percentage}")
		@Operation(summary = "Update Operation",description = "Updating Player Information Into Data Base Table")
		@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Sucessful operation -OK")})
		public ResponseEntity<String> updatePlayerPrice(@PathVariable("id") int id,
				@PathVariable("percentage") double percentage) throws Exception{
			
			String msg=service.updatePlayerById(id, percentage);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
			
}
		@DeleteMapping("/delete/{start}/{end}")
		@Operation(summary = "Delete Operation",description = "Delete Player Information from Data Base Table")
		@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Sucessful operation -OK")})
		public ResponseEntity<String> deletePlayerbySalaryRange(@PathVariable("start") double start,
				@PathVariable("end") double end)throws Exception{
		
			String msg=service.removePlayersByPriceRange(start, end);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
			
}
		@GetMapping("/delete/{id}")
		@Operation(summary = "Delete Operation By Player ID",description = "Delete Player Information from Data Base Table")
		@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Sucessful operation -OK")})
		public ResponseEntity<String> removePlayeryId(@PathVariable("id") int id)throws Exception{
		
			String msg=service.removePlayerById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
			
}
}