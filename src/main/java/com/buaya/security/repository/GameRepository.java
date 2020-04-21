package com.buaya.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.buaya.security.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	
	@Transactional
	@Modifying
	@Query("SELECT game.gameName FROM Game game")
	List<String> findGameName();

	@Query("SELECT game.gameDate FROM Game game WHERE game.gameName= :gameName")
	List<String> findGameDate(String gameName);
}