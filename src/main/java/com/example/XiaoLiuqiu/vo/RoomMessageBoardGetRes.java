package com.example.XiaoLiuqiu.vo;

import java.util.List;

import com.example.XiaoLiuqiu.entity.RoomMessageBoard;

public class RoomMessageBoardGetRes extends RoomMessageBoardRes{

	private List<RoomMessageBoard> messageList;

	public RoomMessageBoardGetRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomMessageBoardGetRes(int code, String message,List<RoomMessageBoard> messageList) {
		super(code, message);
		this.messageList = messageList;
	}

	public List<RoomMessageBoard> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<RoomMessageBoard> messageList) {
		this.messageList = messageList;
	}
	

	
	
}
