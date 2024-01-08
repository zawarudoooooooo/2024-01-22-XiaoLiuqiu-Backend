package com.example.XiaoLiuqiu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message_board")
public class MessageBoard {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "message_board_id")
	private int messageBoardId;
	
	@Column(name = "member_name")
	private String memberName;
	
	@Column(name = "message_board_description")
	private String messageBoardDescription;

	public MessageBoard() {
		super();
	}

	public MessageBoard(int messageBoardId, String memberName, String messageBoardDescription) {
		super();
		this.messageBoardId = messageBoardId;
		this.memberName = memberName;
		this.messageBoardDescription = messageBoardDescription;
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

	public String getMessageBoardDescription() {
		return messageBoardDescription;
	}

	public void setMessageBoardDescription(String messageBoardDescription) {
		this.messageBoardDescription = messageBoardDescription;
	}
	
	

}
