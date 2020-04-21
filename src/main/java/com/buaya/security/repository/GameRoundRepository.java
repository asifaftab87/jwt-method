package com.buaya.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.buaya.security.model.GameRound;

public interface GameRoundRepository extends JpaRepository<GameRound, Long> {
	
	@Transactional
	@Modifying
	@Query("SELECT gameRound.grossScore, gameRound.handicap ,gameRound.netScore FROM GameRound gameRound WHERE gameRound.gameId= :gameId")
	List<String> find(int gameId);

//	@Query("SELECT game.gameDate FROM Game game WHERE game.gameName= :gameName")
//	List<String> findGameDate(String gameName);

}