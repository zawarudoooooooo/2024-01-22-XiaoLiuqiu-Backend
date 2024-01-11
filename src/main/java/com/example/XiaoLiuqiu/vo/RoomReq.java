package com.example.XiaoLiuqiu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomReq {

	@JsonProperty(value = "room_id")
	private String roomId;

	@JsonProperty(value = "room_type_id")
	private int roomTypeId;

	@JsonProperty(value = "room_introduce")
	private String roomIntroduce;

	public RoomReq() {
		super();
	}

	public RoomReq(String roomId, int roomTypeId, String roomIntroduce) {
		super();
		this.roomId = roomId;
		this.roomTypeId = roomTypeId;
		this.roomIntroduce = roomIntroduce;
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

	public String getRoomIntroduce() {
		return roomIntroduce;
	}

	public void setRoomIntroduce(String roomIntroduce) {
		this.roomIntroduce = roomIntroduce;
	}

}
