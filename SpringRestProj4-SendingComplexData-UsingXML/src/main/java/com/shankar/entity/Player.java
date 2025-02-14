package com.shankar.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
	
	private Integer pid;
	private String pname;
	private String pteam;
	private Double pprice;
	
	private String[] favcolours;
	private List<String> nickNames;
	private Set<Long> phoneNumbers;
	private Map<String,Integer> idDetails;
	
	private Team team;

}
