package com.example.XiaoLiuqiu.vo;

import java.util.List;

import com.example.XiaoLiuqiu.entity.Room;

public class RoomGetRes extends RoomRes{
	
	private List<Room> roomList;

	public RoomGetRes() {
		super();
	}

	public RoomGetRes(int rtnCode, String message, List<Room> roomList) {
		super(rtnCode, message);
		this.roomList = roomList;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}
	

}
