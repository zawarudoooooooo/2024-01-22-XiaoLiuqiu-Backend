package com.example.XiaoLiuqiu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.XiaoLiuqiu.entity.RoomType;

@Repository
public interface RoomTypeDAO extends JpaRepository<RoomType, Integer>{
	
	public List<RoomType> findByRoomTypeNameContaining(String roomTypeName);

}
