package com.shankar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shankar.entity.IPLPlayer;

public interface IPLPlayerRepository extends JpaRepository<IPLPlayer,Integer> {

}
