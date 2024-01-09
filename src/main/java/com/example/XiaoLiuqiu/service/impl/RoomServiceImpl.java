package com.example.XiaoLiuqiu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Room;
import com.example.XiaoLiuqiu.repository.RoomDAO;
import com.example.XiaoLiuqiu.service.ifs.RoomService;
import com.example.XiaoLiuqiu.vo.RoomGetRes;
import com.example.XiaoLiuqiu.vo.RoomRes;

@Service
public class RoomServiceImpl implements RoomService{
	
	@Autowired
	private RoomDAO roomDao;

	@Override
	public RoomRes search(String roomId) {
		roomId = !StringUtils.hasText(roomId) ? "" : roomId;
//		roomTypeId = roomTypeId <= 10 ? 0 : roomTypeId;
		List<Room> res = roomDao.findByRoomIdContaining(roomId);
		return new RoomGetRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}









}
