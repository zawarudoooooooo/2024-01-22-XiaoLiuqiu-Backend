package com.example.XiaoLiuqiu.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.XiaoLiuqiu.entity.Room;

@Repository
public interface RoomDAO extends JpaRepository<Room, String>{

	public List<Room> findByRoomIdContaining(String roomId);
	
	@Transactional(rollbackOn = Exception.class)
	@Modifying
	@Query(value = "insert into room(room_id, room_type_id, room_introduce)"
			+ "select :room_id, :room_type_id, :room_introduce "
			+ "where not exists (select 1 from room where room_id = :room_id)",		
	nativeQuery = true)
	public int insertRoom(//
			@Param("room_id")String roomId,//
			@Param("room_type_id")int roomTypeId,
			@Param("room_introduce")String roomIntroduce);
	
	@Transactional(rollbackOn = Exception.class)
	@Modifying(clearAutomatically = true)
	@Query(value = "update room set "
			+ " room_id = :room_id, room_type_id = :room_type_id, room_introduce = :room_introduce "
			+ " where room_id = :room_id", nativeQuery = true)
	public int updateRoom(//
			@Param("room_id")String roomId,//
			@Param("room_type_id")int roomTypeId,
			@Param("room_introduce")String roomIntroduce);
	
}
