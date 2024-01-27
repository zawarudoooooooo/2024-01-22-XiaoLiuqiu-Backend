package com.example.XiaoLiuqiu.vo;

public class RoomMessageBoardReq {

	private String memberName;

	private String roomId;

	private String roomMessageBoardDescription;

	private String messageImg;

	private String account;

	public RoomMessageBoardReq() {
		super();
	}

	public RoomMessageBoardReq(String memberName, String roomId, String roomMessageBoardDescription, String messageImg,
			String account) {
		super();
		this.memberName = memberName;
		this.roomId = roomId;
		this.roomMessageBoardDescription = roomMessageBoardDescription;
		this.messageImg = messageImg;
		this.account = account;
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

	public String getMessageImg() {
		return messageImg;
	}

	public void setMessageImg(String messageImg) {
		this.messageImg = messageImg;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}
