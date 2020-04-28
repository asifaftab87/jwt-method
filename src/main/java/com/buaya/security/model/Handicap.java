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
	private int id;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="handicap_value")
	private String handicapValue;
	
	public Handicap() {}
	
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
