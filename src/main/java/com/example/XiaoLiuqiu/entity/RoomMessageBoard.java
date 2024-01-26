package com.example.XiaoLiuqiu.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room_message_board")
public class RoomMessageBoard {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "room_message_board_id")
	private int messageBoardId;
	
	@Column(name = "member_name")
	private String memberName;
	
	@Column(name = "room_id")
	private String roomId;
	
	@Column(name = "room_message_board_description")
	private String roomMessageBoardDescription;
	
	@Column(name = "message_date_time")
	private LocalDateTime messageDateTime;

	public RoomMessageBoard() {
		super();
	}

	

	

	public RoomMessageBoard(String memberName, String roomId, String roomMessageBoardDescription,
			LocalDateTime messageDateTime) {
		super();
		this.memberName = memberName;
		this.roomId = roomId;
		this.roomMessageBoardDescription = roomMessageBoardDescription;
		this.messageDateTime = messageDateTime;
	}





	public int getMessageBoardId() {
		return messageBoardId;
	}

	public void setMessageBoardId(int messageBoardId) {
		this.messageBoardId = messageBoardId;
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





	public LocalDateTime getMessageDateTime() {
		return messageDateTime;
	}





	public void setMessageDateTime(LocalDateTime messageDateTime) {
		this.messageDateTime = messageDateTime;
	}



	

	
	
	

}
