package com.example.XiaoLiuqiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.service.ifs.MemberService;
import com.example.XiaoLiuqiu.vo.MemberLoginReq;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;
import com.example.XiaoLiuqiu.vo.MemberSignUpReq;

@CrossOrigin
@RestController
public class MemberServiceController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping(value="member/login")
	public MemberLoginRes login(@RequestBody MemberLoginReq req) {
		return memberService.login(req.getAccount(), req.getPwd());
	}
	@PostMapping(value="member/signUp")
	public MemberLoginRes signUp(@RequestBody MemberSignUpReq req) {
		return memberService.signUp(req.getAccount(), req.getPwd(), req.getMemberName(), req.getMemberPhone()
				, req.getMemberEmail());
	}
	
}
