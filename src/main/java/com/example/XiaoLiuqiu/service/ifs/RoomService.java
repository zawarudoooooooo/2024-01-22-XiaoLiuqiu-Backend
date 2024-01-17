package com.example.XiaoLiuqiu.service.ifs;

import com.example.XiaoLiuqiu.vo.RoomRes;

public interface RoomService {
	
	public RoomRes search(String roomName);

	public RoomRes createRoom(String roomId, String roomIntroduce, String roomName, int roomPrice);
	
	public RoomRes updateRoom(String roomId, String roomIntroduce, String roomName, int roomPrice);
	
}
