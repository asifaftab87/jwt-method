package com.buaya.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@Entity
@ApiModel(description = "All details about the membership ")
public class PlayerStatus extends AbstractEntity {
	@ApiModelProperty(notes = "Player name")
	@Column(name="name")
  private String name;
	@ApiModelProperty(notes = "Player membership number")
	@Column(name="memberShipNo")
  private String memberShipNo;
	@ApiModelProperty(notes = "Player membership status")
	@Column(name="status")	
	private String status;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMemberShipNo() {
	return memberShipNo;
}
public void setMemberShipNo(String memberShipNo) {
	this.memberShipNo = memberShipNo;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
