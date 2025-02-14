package com.shankar.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerInfo implements Serializable{
	
	private String playerId;
	private String playerName;
	private String playerTeam;
	
	

}
