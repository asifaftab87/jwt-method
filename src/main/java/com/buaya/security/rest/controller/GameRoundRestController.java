package com.buaya.security.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buaya.security.service.GameRoundService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/gameRound")
public class GameRoundRestController {

	@Autowired
	GameRoundService gameRoundService;
	
	@GetMapping(value="/find/GameRound/{gameId}")
	@ApiOperation(value="Get round details")
	public List<String> find(@PathVariable int gameId){
		return gameRoundService.find(gameId);
	}
}