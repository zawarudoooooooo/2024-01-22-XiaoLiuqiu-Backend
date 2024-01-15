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
	public RoomRes search(String roomId, int roomTypeId, String roomIntroduce, String roomName, int roomPrice) {
		roomId = !StringUtils.hasText(roomId) ? "" : roomId;
//		roomTypeId = roomTypeId <= 10 ? 0 : roomTypeId;
		List<Room> res = roomDao.findByRoomIdContaining(roomId);
		return new RoomGetRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}

	@Override
	public RoomRes createRoom(String roomId, int roomTypeId, String roomIntroduce, String roomName, int roomPrice) {
		if(roomDao.existsByRoomId(roomId)) {
			return new RoomRes(RtnCode.Room_ID_IS_EXISTED.getCode(), RtnCode.Room_ID_IS_EXISTED.getMessage());
		}
		roomDao.insertRoom(roomId, roomTypeId, roomIntroduce, roomName, roomPrice);
		return new RoomRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public RoomRes updateRoom(String roomId ,int roomTypeId, String roomIntroduce , String roomName, int roomPrice) {
		roomDao.updateRoom(roomId ,roomTypeId, roomIntroduce, roomName, roomPrice);
		return new RoomRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}









}
