package com.buaya.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "All details about the round of the game ")
public class GameRound extends AbstractEntity{
	
	@ApiModelProperty(notes = "Game Id")
	@Column(name="game_id")
	private int gameId;
	
	@ApiModelProperty(notes = "Score card for the round")
	@Column(name="gross_score")
	private int grossScore;
	
	@ApiModelProperty(notes = "Handicap of round")
	@Column(name="handicap")
	private int handicap;
	
	@ApiModelProperty(notes = "Net score of the round")
	@Column(name="net_score")
	private int netScore;

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getGrossScore() {
		return grossScore;
	}

	public void setGrossScore(int grossScore) {
		this.grossScore = grossScore;
	}

	public int getHandicap() {
		return handicap;
	}

	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}

	public int getNetScore() {
		return netScore;
	}

	public void setNetScore(int netScore) {
		this.netScore = netScore;
	}
	
}
