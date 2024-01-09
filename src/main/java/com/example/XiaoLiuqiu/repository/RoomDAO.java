package com.example.XiaoLiuqiu.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.XiaoLiuqiu.entity.Room;
import com.example.XiaoLiuqiu.vo.RoomGetRes;

@Repository
public interface RoomDAO extends JpaRepository<Room, String>{

	public List<Room> findByRoomIdContaining(String roomId);
	
}
