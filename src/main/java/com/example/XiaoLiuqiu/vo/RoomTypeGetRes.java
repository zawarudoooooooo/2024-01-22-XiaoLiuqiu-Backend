package com.example.XiaoLiuqiu.vo;

import java.util.List;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.RoomType;

public class RoomTypeGetRes extends RoomTypeRes {

	private List<RoomType> roomTypeList;

	public RoomTypeGetRes() {
		super();
	}

	public RoomTypeGetRes(RtnCode rtnCode, List<RoomType> roomTypeList) {
		super(rtnCode);
		this.roomTypeList = roomTypeList;
	}

	public List<RoomType> getRoomTypeList() {
		return roomTypeList;
	}

	public void setRoomTypeList(List<RoomType> roomTypeList) {
		this.roomTypeList = roomTypeList;
	}

}
