package com.example.XiaoLiuqiu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.XiaoLiuqiu.entity.RoomMessageBoard;

public interface RoomMessageBoardDAO extends JpaRepository<RoomMessageBoard, Integer>{
	
//	public List<RoomMessageBoard> findByMemberNameContainingAndRoomIdContainingAndRoomMessageBoardDescriptionContaining(String memberName, String roomId, String roomMessageBoardDescription);

//	List<RoomMessageBoard> findByMemberNameContainingAndRoomIdContainingAndRoomMessageBoardDescriptionContaining(
//		    String memberName, String roomId, String roomMessageBoardDescription);
	
	
	@Query(value="select * from room_message_board where member_name like %:memberName%"
			+ " AND room_id like %:roomId%"
			+ " AND room_message_board_description like %:roomMessageBoardDescription%",nativeQuery = true)
	public List<RoomMessageBoard> findByLike(@Param("memberName")String memberName, 
			@Param("roomId")String roomId, @Param("roomMessageBoardDescription")String roomMessageBoardDescription);

}
