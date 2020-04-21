package com.buaya.security.service;

import java.util.List;

import com.buaya.security.model.Game;

public interface GameService {

	Game create(Game game);
	Game findById(long id);	
	List<Game> findAll();
	List<String> findGameName();
	List<String> findGameDate(String gameName);
	
	
}