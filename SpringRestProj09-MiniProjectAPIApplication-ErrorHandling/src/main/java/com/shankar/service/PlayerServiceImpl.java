package com.shankar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shankar.entity.Player;
import com.shankar.exception.PlayerNotFoundException;
import com.shankar.repo.PlayerRepository;
@Service
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepository playerrepo;

	@Override
	public String savePlayer(Player player) {
		int idVal=playerrepo.save(player).getPid();
		return "Player is Saved With the value is"+idVal;
	}

	@Override
	public List<Player> getAllPayersInfo() {
		List<Player> list=playerrepo.findAll();
		return list;
	}

	@Override
	public Player findPlayerByid(int pid) throws PlayerNotFoundException {
	
		return playerrepo.findById(pid).orElseThrow(()-> new IllegalArgumentException(pid+"Player is not found"));
	}

	@Override
	public String updatePlayerDetails(Player player) throws PlayerNotFoundException {
	Optional<Player> opt=playerrepo.findById(player.getPid());
	if(opt.isPresent()) {
	playerrepo.save(player);
	return player.getPid()+"Player is Updated";
	}
	else {
		 throw new PlayerNotFoundException(player.getPid()+"Player is Not found to Update");
	}
	}

	@Override
	public String updatePlayerById(int id, double percentage) throws PlayerNotFoundException {
	
		Optional<Player> opt=playerrepo.findById(id);
		if(opt.isPresent()) {
			Player player=opt.get();
		double price=player.getPprice();
		double newprice=player.getPprice()+(player.getPprice()*percentage/100.0);
		player.setPprice(newprice);
		playerrepo.save(player);
		return "Player Price is updated with new Value"+newprice;
		}
		else  throw new PlayerNotFoundException(id+"Player is not found for updation");
	}

	@Override
	public String removePlayersByPriceRange(double start, double end) {
	int count=playerrepo.removePlayerById(start, end);
		return count==0?"Players Found for Deletion":count+"no of Players are Deleted";
	}

	@Override
	public String removePlayerById(int id) throws PlayerNotFoundException {
	Optional<Player> opt=playerrepo.findById(id);
	if(opt.isPresent()) {
		playerrepo.deleteById(id);
		return id+"Player is Found And Deleted";
	}
	else {
		 throw new PlayerNotFoundException(id+"Player is not found to deleted");
	}
	}

	/*
	 * @Override public List<Player> findAllPlayersByName(String pname) {
	 * 
	 * return playerrepo.getPlayersByName(pname); }
	 */

}
