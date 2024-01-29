package com.example.XiaoLiuqiu.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoomReq {

	@JsonProperty(value = "room_id")
	private String roomId;

	@JsonProperty(value = "room_introduce")
	private String roomIntroduce;

	@JsonProperty(value = "room_name")
	private String roomName;

	@JsonProperty(value = "room_price")
	private int roomPrice;
	
	@JsonProperty(value = "is_open")
	private boolean isOpen;
	
<<<<<<< HEAD
	
=======
	@JsonProperty(value = "room_img")
	private String roomImg;

>>>>>>> e8ce7168674f56e831483fa703f1bd0f7c8ea876
	public RoomReq() {
		super();
	}

<<<<<<< HEAD
	public RoomReq(String roomId, String roomIntroduce, String roomName, int roomPrice, boolean isOpen) {
=======
	public RoomReq(String roomId, String roomIntroduce, String roomName, int roomPrice, boolean isOpen,
			String roomImg) {
>>>>>>> e8ce7168674f56e831483fa703f1bd0f7c8ea876
		super();
		this.roomId = roomId;
		this.roomIntroduce = roomIntroduce;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
		this.isOpen = isOpen;
		this.roomImg = roomImg;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
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

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public String getRoomImg() {
		return roomImg;
	}

	public void setRoomImg(String roomImg) {
		this.roomImg = roomImg;
	}

}
