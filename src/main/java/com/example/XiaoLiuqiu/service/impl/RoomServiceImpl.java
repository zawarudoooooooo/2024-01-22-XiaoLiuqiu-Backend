package com.example.XiaoLiuqiu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.XiaoLiuqiu.repository.RoomDAO;
import com.example.XiaoLiuqiu.service.ifs.RoomService;
import com.example.XiaoLiuqiu.vo.RoomRes;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomDAO roomDao;

	@Override
	public RoomRes roomInfo(String roomId, int roomTypeId, String roomIntroduce) {
		
		return null;
	}
	
	

}
