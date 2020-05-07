package com.buaya.security.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "handicap")
public class Handicap implements Serializable{
	
	private static final long serialVersionUID = 4209811032693461393L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="handicap_value")
	private long handicapValue;
	
	public Handicap() {}
	
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
