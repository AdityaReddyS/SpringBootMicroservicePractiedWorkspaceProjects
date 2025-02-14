package com.shankar.entity;

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

}
