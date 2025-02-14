package com.shankar.clientcomp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shankar.entity.IPLTeam;



@FeignClient("TEAM-SERVICE")
public interface IPLTeamServiceMSClient {

	 @GetMapping("/team-api/find/{id}")
	 public  IPLTeam   getTeamById(@PathVariable int id);
}
