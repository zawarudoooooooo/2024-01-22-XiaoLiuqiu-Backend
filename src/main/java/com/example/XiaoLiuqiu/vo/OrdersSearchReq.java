package com.example.XiaoLiuqiu.vo;

import java.time.LocalDate;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdersSearchReq {

	@Column(name = "room_name")
	private String roomName;
	
	@JsonProperty(value = "start_date")
	private LocalDate startDate;
	
	@JsonProperty(value = "end_date")
	private LocalDate endDate;

	public OrdersSearchReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersSearchReq(String roomName, LocalDate startDate, LocalDate endDate) {
		super();
		this.roomName = roomName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	
	
	
}
