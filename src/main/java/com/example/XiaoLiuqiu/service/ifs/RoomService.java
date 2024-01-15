package com.example.XiaoLiuqiu.service.ifs;

import com.example.XiaoLiuqiu.vo.RoomRes;

public interface RoomService {
	
	public RoomRes search(String roomId, int roomTypeId, String roomIntroduce, String roomName, int roomPrice);

	public RoomRes createRoom(String roomId, int roomTypeId, String roomIntroduce, String roomName, int roomPrice);
	
	public RoomRes updateRoom(String roomId ,int roomTypeId, String roomIntroduce, String roomName, int roomPrice);
	
}
