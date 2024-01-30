package com.example.XiaoLiuqiu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.RoomType;
import com.example.XiaoLiuqiu.repository.RoomTypeDAO;
import com.example.XiaoLiuqiu.service.ifs.RoomTypeService;
import com.example.XiaoLiuqiu.vo.RoomTypeGetrRes;
import com.example.XiaoLiuqiu.vo.RoomTypeRes;

@Service
public class RoomTypeServiceImpl implements RoomTypeService{
	
	@Autowired
	private RoomTypeDAO roomTypeDao;
	

	@Override
	public RoomTypeRes createRoomType(String roomTypeName) {
		if(!StringUtils.hasText(roomTypeName)) {
			return new RoomTypeRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage());
		}
		if(roomTypeDao.existsByRoomTypeName(roomTypeName)) {
			return new RoomTypeRes(RtnCode.ROOM_TYPE_EXISTED.getCode(),RtnCode.ROOM_TYPE_EXISTED.getMessage());
		}
		roomTypeDao.save(new RoomType(roomTypeName));
		
		return new RoomTypeRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}


	@Override
	public RoomTypeRes search(String roomTypeName) {
		roomTypeName=!StringUtils.hasText(roomTypeName)?"":roomTypeName;
		List<RoomType> res =roomTypeDao.findByRoomTypeNameContaining(roomTypeName);
		return new RoomTypeGetrRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage(),res);
	}

}
