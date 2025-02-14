package com.shankar.service;

import java.util.List;

import com.shankar.entity.IPLTeam;

public interface IplTeamService {
	  public  String registerIPLTeam(IPLTeam team);
	     public   List<IPLTeam> getAllTeams();
	     public    IPLTeam    getTeamById(int teamId);
}
