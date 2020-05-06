package com.buaya.security.dto;

import java.io.Serializable;

public class HandicapDTO implements Serializable{
	
	private static final long serialVersionUID = 2077720922426795075L;

	private long id;
	
	private int userId;
	
	private long handicapValue;
	
	public HandicapDTO() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getHandicapValue() {
		return handicapValue;
	}

	public void setHandicapValue(long handicapValue) {
		this.handicapValue = handicapValue;
	}

	@Override
	public String toString() {
		return "{ id: "+ id+ ", userId: " +userId+", handicapValue: "+handicapValue+" }";
	}
}
