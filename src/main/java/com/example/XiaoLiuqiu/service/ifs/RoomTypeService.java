package com.example.XiaoLiuqiu.service.ifs;

import com.example.XiaoLiuqiu.vo.RoomTypeRes;

public interface RoomTypeService {
	
	public RoomTypeRes search(int roomTypeId, String roomTypeName, int roomTypePrice);

}
