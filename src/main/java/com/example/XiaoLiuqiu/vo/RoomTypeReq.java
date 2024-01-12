package com.example.XiaoLiuqiu.vo;

public class RoomTypeReq {

	private int roomTypeID;

	private String roomTypeName;

	private int roomTypePrice;

	public RoomTypeReq() {
		super();
	}

	public RoomTypeReq(int roomTypeID, String roomTypeName, int roomTypePrice) {
		super();
		this.roomTypeID = roomTypeID;
		this.roomTypeName = roomTypeName;
		this.roomTypePrice = roomTypePrice;
	}

	public int getRoomTypeID() {
		return roomTypeID;
	}

	public void setRoomTypeID(int roomTypeID) {
		this.roomTypeID = roomTypeID;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public int getRoomTypePrice() {
		return roomTypePrice;
	}

	public void setRoomTypePrice(int roomTypePrice) {
		this.roomTypePrice = roomTypePrice;
	}

}
