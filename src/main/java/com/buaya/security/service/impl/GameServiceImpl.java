package com.buaya.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buaya.security.model.Game;
import com.buaya.security.repository.GameRepository;
import com.buaya.security.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;

	@Override
	public Game create(Game game) {
		return gameRepository.save(game);
	}

	@Override
	public List<Game> findAll() {
		return gameRepository.findAll();
	}
	
	@Override
	public Game findById(long id) {
		Optional<Game> optional = gameRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public List<String> findGameName() {
		return gameRepository.findGameName();
	}

	@Override
	public List<String> findGameDate(String gameName) {
		return gameRepository.findGameDate(gameName);

	}
}