package com.example.XiaoLiuqiu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.XiaoLiuqiu.entity.RoomType;

public interface RoomTypeDAO extends JpaRepository<RoomType,Integer>{
	
	public boolean existsByRoomTypeName(String roomTypeName);
	
	public List<RoomType> findByRoomTypeNameContaining(String roomTypeName);

}
