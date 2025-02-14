package com.shankar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shankar.entity.IPLTeam;

public interface IPLTeamRepository extends JpaRepository<IPLTeam, Integer> {

}
