package com.example.XiaoLiuqiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.service.ifs.RoomMessageBoardService;
import com.example.XiaoLiuqiu.vo.RoomMessageBoardReq;
import com.example.XiaoLiuqiu.vo.RoomMessageBoardRes;

@CrossOrigin
@RestController
public class RoomMessageBoardServiceController {
	
	@Autowired
	private RoomMessageBoardService roomMessageBoardService;
	
	@PostMapping(value="message/messageCreate")
	public RoomMessageBoardRes messageCreate(@RequestBody RoomMessageBoardReq req) {
		
		return roomMessageBoardService.messageCreate(req.getMemberName(), req.getRoomId(), 
				req.getRoomMessageBoardDescription(),req.getMessageImg(),req.getAccount());
	}
	@PostMapping(value="message/search")
	public RoomMessageBoardRes search(@RequestBody RoomMessageBoardReq req) {
		
		return roomMessageBoardService.search(req.getMemberName(), req.getRoomId(), req.getRoomMessageBoardDescription());
	}

}
