package com.example.XiaoLiuqiu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.XiaoLiuqiu.entity.RoomMessageBoard;

public interface RoomMessageBoardDAO extends JpaRepository<RoomMessageBoard, Integer>{
	
//	public List<RoomMessageBoard> findByMemberNameContainingAndRoomIdContainingAndRoomMessageBoardDescriptionContaining(String memberName, String roomId, String roomMessageBoardDescription);

//	List<RoomMessageBoard> findByMemberNameContainingAndRoomIdContainingAndRoomMessageBoardDescriptionContaining(
//		    String memberName, String roomId, String roomMessageBoardDescription);

}
