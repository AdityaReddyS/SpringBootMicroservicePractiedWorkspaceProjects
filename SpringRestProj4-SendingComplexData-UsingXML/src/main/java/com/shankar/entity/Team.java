package com.shankar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {
private Integer tid;
private String teamname;
private Integer tsize;
private String teamOwner;

}
