package com.example.XiaoLiuqiu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.XiaoLiuqiu.entity.RoomMessageBoard;

public interface RoomMessageBoardDAO extends JpaRepository<RoomMessageBoard, Integer>{
	
	
//								  findByRoomIdContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual
//								  
	
//	public List<RoomMessageBoard> findByMemberNameContainingIgnoreCaseAndRoomIdAndRoomMessageBoardDescriptionContainingIgnoreCase(String memberName, String roomId, String roomMessageBoardDescription);
}
