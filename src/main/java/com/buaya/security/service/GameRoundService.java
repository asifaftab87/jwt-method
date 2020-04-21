package com.buaya.security.service;

import java.util.List;

import springfox.documentation.spring.web.json.Json;

public interface GameRoundService {

	List<String> find(int gameId);
	List<Integer> create(Json Jobj);
	List<Integer> update(Json Jobj);
}