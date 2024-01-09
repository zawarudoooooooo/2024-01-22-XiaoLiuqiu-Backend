package com.example.XiaoLiuqiu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomReq {
	
	@JsonProperty(value = "room_id")
	private String roomId;
	
	@JsonProperty(value = "room_type_id")
	private int roomTypeId;

	public RoomReq() {
		super();
	}

	public RoomReq(String roomId, int roomTypeId) {
		super();
		this.roomId = roomId;
		this.roomTypeId = roomTypeId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public int getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	
}
