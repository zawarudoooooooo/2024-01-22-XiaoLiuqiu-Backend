package com.example.XiaoLiuqiu.service.ifs;

import com.example.XiaoLiuqiu.vo.RoomTypeRes;

public interface RoomTypeService {
	
	public RoomTypeRes createRoomType(String roomTypeName);
	
	public RoomTypeRes search (String roomTypeName);

}
