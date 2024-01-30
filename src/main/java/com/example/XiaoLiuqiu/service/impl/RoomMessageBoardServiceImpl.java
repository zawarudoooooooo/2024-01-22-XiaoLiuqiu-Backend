package com.example.XiaoLiuqiu.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.RoomMessageBoard;
import com.example.XiaoLiuqiu.repository.RoomMessageBoardDAO;
import com.example.XiaoLiuqiu.service.ifs.RoomMessageBoardService;
import com.example.XiaoLiuqiu.vo.RoomMessageBoardGetRes;
import com.example.XiaoLiuqiu.vo.RoomMessageBoardRes;

@Service
public class RoomMessageBoardServiceImpl implements RoomMessageBoardService{
	
	@Autowired
	private RoomMessageBoardDAO roomMessageBoardDao;

	@Override
	public RoomMessageBoardRes messageCreate(String memberName, String roomId, String roomMessageBoardDescription,
			String messageImg, String memberImg) {
		if(!StringUtils.hasText(memberName)||!StringUtils.hasText(memberImg)||!StringUtils.hasText(roomId)||!StringUtils.hasText(roomMessageBoardDescription)) {
			return new RoomMessageBoardRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage());
		}
		roomMessageBoardDao.save(new RoomMessageBoard(memberName,roomId,roomMessageBoardDescription,
				LocalDateTime.now(),messageImg,memberImg));
		return new RoomMessageBoardRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public RoomMessageBoardGetRes search(String memberName, String roomId, String roomMessageBoardDescription) {
		memberName=!StringUtils.hasText(memberName)?"":memberName;
		roomId=!StringUtils.hasText(roomId)?"":roomId;
		roomMessageBoardDescription=!StringUtils.hasText(roomMessageBoardDescription)?"":roomMessageBoardDescription;
		List<RoomMessageBoard> res=roomMessageBoardDao.findByLike(memberName, roomId, roomMessageBoardDescription);
		return new RoomMessageBoardGetRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage(),res);
	}

}
