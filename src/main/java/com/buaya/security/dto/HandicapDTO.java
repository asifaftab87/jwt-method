package com.buaya.security.dto;

import java.io.Serializable;

public class HandicapDTO implements Serializable{
	
	private static final long serialVersionUID = 2077720922426795075L;

	private int id;
	
	private int userId;
	
	private String handicapValue;
	
	public HandicapDTO() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getHandicapValue() {
		return handicapValue;
	}

	public void setHandicapValue(String handicapValue) {
		this.handicapValue = handicapValue;
	}

	@Override
	public String toString() {
		return "{ id: "+ id+ ", userId: " +userId+", handicapValue: "+handicapValue+" }";
	}
}
