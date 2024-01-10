package com.example.XiaoLiuqiu.vo;

public class RoomMessageBoardReq {
	
	private String memberName;
	
	private String roomId;
	
	private String roomMessageBoardDescription;

	public RoomMessageBoardReq() {
		super();
	}

	public RoomMessageBoardReq(String memberName, String roomId, String roomMessageBoardDescription) {
		super();
		this.memberName = memberName;
		this.roomId = roomId;
		this.roomMessageBoardDescription = roomMessageBoardDescription;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getRoomMessageBoardDescription() {
		return roomMessageBoardDescription;
	}

	public void setRoomMessageBoardDescription(String roomMessageBoardDescription) {
		this.roomMessageBoardDescription = roomMessageBoardDescription;
	}
	
	

}
