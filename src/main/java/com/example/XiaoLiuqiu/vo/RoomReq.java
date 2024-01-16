package com.example.XiaoLiuqiu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomReq {

	@JsonProperty(value = "room_id")
	private String roomId;

	@JsonProperty(value = "room_type_id")
	private int roomTypeId;

	@JsonProperty(value = "room_introduce")
	private String roomIntroduce;

	@JsonProperty(value = "room_name")
	private String roomName;

	@JsonProperty(value = "room_price")
	private int roomPrice;

	public RoomReq() {
		super();
	}

	public RoomReq(String roomId, int roomTypeId, String roomIntroduce, String roomName, int roomPrice) {
		super();
		this.roomId = roomId;
		this.roomTypeId = roomTypeId;
		this.roomIntroduce = roomIntroduce;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
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

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

}
