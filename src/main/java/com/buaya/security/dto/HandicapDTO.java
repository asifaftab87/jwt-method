package com.buaya.security.dto;

import java.io.Serializable;

public class HandicapDTO implements Serializable{
	
	private static final long serialVersionUID = 2077720922426795075L;

	private long id;
	
	private long userId;
	
	private long handicapValue;
	
	public HandicapDTO() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
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
