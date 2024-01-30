package com.example.XiaoLiuqiu.vo;

import java.util.List;

import com.example.XiaoLiuqiu.entity.RoomType;

public class RoomTypeGetrRes extends RoomTypeRes{

	private List<RoomType> roomTypeList;

	public RoomTypeGetrRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomTypeGetrRes(int rtnCode, String message,List<RoomType> roomTypeList) {
		super(rtnCode, message);
		this.roomTypeList = roomTypeList;
	}

	public List<RoomType> getRoomTypeList() {
		return roomTypeList;
	}

	public void setRoomTypeList(List<RoomType> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}
	
	
	
}
