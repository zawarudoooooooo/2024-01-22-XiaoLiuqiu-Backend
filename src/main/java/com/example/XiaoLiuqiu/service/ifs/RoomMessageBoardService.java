package com.example.XiaoLiuqiu.service.ifs;

import com.example.XiaoLiuqiu.vo.RoomMessageBoardGetRes;
import com.example.XiaoLiuqiu.vo.RoomMessageBoardRes;

public interface RoomMessageBoardService {
	
	public RoomMessageBoardRes messageCreate(String memberName,String roomId,String roomMessageBoardDescription);
	
	public RoomMessageBoardGetRes search(String memberName,String roomId,String roomMessageBoardDescription);

}
