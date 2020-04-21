package com.buaya.security.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "All details about the Game. ")
public class Game extends AbstractEntity{

	@ApiModelProperty(notes = "Game occurence date")
	@Column(name="game_date")
	private Date gameDate;
	
	@ApiModelProperty(notes = "Game name")
	@Column(name="game_name")
	private String gameName;

	@ApiModelProperty(notes = "Game system name")
	@Column(name="sys_game_name")
	private String sysGameName;

	@ApiModelProperty(notes = "Game lunch available")
	@Column(name="lunch_available")
	private boolean lunchAvailable;
	
	@ApiModelProperty(notes = "Game booker needed")
	@Column(name="booker_needed")
	private boolean bookerAvailable;
	
	public Game() {}
	
	public Date getGameDate() {
		return gameDate;
	}
	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getSysGameName() {
		return sysGameName;
	}
	public void setSysGameName(String sysGameName) {
		this.sysGameName = sysGameName;
	}
	public boolean getLunchAvailable() {
		return lunchAvailable;
	}
	public void setLunchAvailable(boolean lunchAvailable) {
		this.lunchAvailable = lunchAvailable;
	}
	public boolean getBookerAvailable() {
		return bookerAvailable;
	}
	public void setBookerAvailable(boolean bookerAvailable) {
		this.bookerAvailable = bookerAvailable;
	}
}
