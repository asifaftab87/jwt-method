package com.buaya.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buaya.security.repository.GameRoundRepository;
import com.buaya.security.service.GameRoundService;

import springfox.documentation.spring.web.json.Json;

@Service
public class GameRoundServiceImpl implements GameRoundService {

	@Autowired
	private GameRoundRepository gameRoundRepository;
	
	@Override
	public List<String> find(int gameId) {
		
		System.err.println(gameRoundRepository.find(gameId));
		return gameRoundRepository.find(gameId);
	}

	@Override
	public List<Integer> create(Json Jobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> update(Json Jobj) {
		// TODO Auto-generated method stub
		return null;
	}

}