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
	public RoomRes search(String roomName) {
		roomName=!StringUtils.hasText(roomName)?"":roomName;
//		roomTypeId = roomTypeId <= 10 ? 0 : roomTypeId;
		List<Room> res = roomDao.findByRoomName(roomName);
		return new RoomGetRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}
	@Override
	public RoomRes createRoom(String roomId, String roomIntroduce, String roomName, int roomPrice, boolean isOpen) {
		if(roomDao.existsByRoomId(roomId)) {
			return new RoomRes(RtnCode.ROOM_ID_IS_EXISTED.getCode(), RtnCode.ROOM_ID_IS_EXISTED.getMessage());
		}
		roomDao.insertRoom(roomId, roomIntroduce, roomName, roomPrice,isOpen);
		return new RoomRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public RoomRes updateRoom(String roomId, String roomIntroduce , String roomName, int roomPrice, boolean isOpen) {
		roomDao.updateRoom(roomId, roomIntroduce, roomName, roomPrice, isOpen);
		return new RoomRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}


}
