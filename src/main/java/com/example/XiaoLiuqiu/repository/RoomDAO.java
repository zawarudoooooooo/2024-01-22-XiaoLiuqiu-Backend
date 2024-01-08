package com.example.XiaoLiuqiu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.XiaoLiuqiu.entity.Room;

@Repository
public interface RoomDAO extends JpaRepository<Room, String>{

}
