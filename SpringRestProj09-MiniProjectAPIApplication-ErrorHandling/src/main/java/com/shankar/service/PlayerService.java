package com.shankar.service;

import java.util.List;

import com.shankar.entity.Player;
import com.shankar.exception.PlayerNotFoundException;

public interface PlayerService {

	public String savePlayer(Player player);
	
	public List<Player> getAllPayersInfo();
	
	public Player findPlayerByid(int pid) throws PlayerNotFoundException;
	
	public String updatePlayerDetails(Player player) throws PlayerNotFoundException;
	
	public String updatePlayerById(int id,double percentage)throws PlayerNotFoundException;
	
	public String removePlayersByPriceRange(double start,double end);
	
	public String removePlayerById(int id) throws PlayerNotFoundException;
	
	//public List<Player> findAllPlayersByName(String pname);
}
