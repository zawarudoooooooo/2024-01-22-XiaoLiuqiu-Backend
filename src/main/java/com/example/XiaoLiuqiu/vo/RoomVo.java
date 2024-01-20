package com.example.XiaoLiuqiu.vo;

import java.time.LocalDate;

public class RoomVo {
	
	private String roomId;
		
	private LocalDate startDate;
	
	private LocalDate endDate;

	private String roomName;
	
	public RoomVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public RoomVo( String roomId, LocalDate startDate, LocalDate endDate, String roomName) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.startDate = startDate;
		this.endDate = endDate;
	}




	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
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
