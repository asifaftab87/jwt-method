package com.buaya.security.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buaya.security.model.Game;
import com.buaya.security.service.GameService;

@RestController
@RequestMapping("/api/game")
public class GameRestController {

	@Autowired
	private GameService gameService;
	
	
	@GetMapping(value = "/findAll")
	public List<Game> findAll(){
		return gameService.findAll();
	}
	
	@PostMapping(value = "/creates")
	public Game create(@RequestBody Game game) {
		return gameService.create(game);
	}
	
	@GetMapping(value = "/find/id/{id}")
	public Game findById(@PathVariable long id) {
		return gameService.findById(id);
	}
	
	@GetMapping(value="/find/gameName")
	public List<String> findGameName(){
		return gameService.findGameName();
	}
	
	@GetMapping(value="/find/gameDate/{gameName}")
	public List<String> findGameDate(@PathVariable String gameName){
		return gameService.findGameDate(gameName);
	}
}