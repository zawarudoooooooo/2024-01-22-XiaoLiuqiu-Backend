package com.example.XiaoLiuqiu.vo;

import java.time.LocalDate;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdersRoomSearchReq {

	@Column(name = "member_name")
	private String memberName;

	public OrdersRoomSearchReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersRoomSearchReq(String memberName) {
		super();
		this.memberName = memberName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	
	
	
}
