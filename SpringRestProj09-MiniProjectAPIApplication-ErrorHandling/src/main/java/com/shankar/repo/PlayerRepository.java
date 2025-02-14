package com.shankar.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shankar.entity.Player;

import jakarta.transaction.Transactional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	/*
	 * @Query("FROM REST_PLAYER WHERE PNAME=:pname") public List<Player>
	 * getPlayersByName(@Param("pname") String pname);
	 */
	@Query("delete from Player where pprice>=:start and pprice<=:end")
	@Modifying
	@Transactional
public int removePlayerById(double start,double end);
}
