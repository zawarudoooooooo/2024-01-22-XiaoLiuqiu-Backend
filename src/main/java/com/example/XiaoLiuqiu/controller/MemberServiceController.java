package com.example.XiaoLiuqiu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.service.ifs.MemberService;
import com.example.XiaoLiuqiu.vo.MemberGetRes;
import com.example.XiaoLiuqiu.vo.MemberLoginReq;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;
import com.example.XiaoLiuqiu.vo.MemberPwdReq;
import com.example.XiaoLiuqiu.vo.MemberSignUpReq;
import com.example.XiaoLiuqiu.vo.MemberUpDateReq;

@CrossOrigin
@RestController
public class MemberServiceController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping(value="member/login")
	public MemberLoginRes login(@RequestBody MemberLoginReq req,HttpSession session) {
		String attr=(String) session.getAttribute("account");
		if(StringUtils.hasText(attr)&&attr.equals(req.getAccount())) {
			return new MemberLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
		}
		MemberLoginRes res=memberService.login(req.getAccount(), req.getPwd());
		if(res.getCode()==200) {
			session.setAttribute("account", req.getAccount());
			//預設有效時間為30秒 
			//設定 session 有效時間, 單位:秒
			session.setMaxInactiveInterval(600);
		}
		
		return res;
	}
	@PostMapping(value="member/signUp")
	public MemberLoginRes signUp(@RequestBody MemberSignUpReq req) {
		return memberService.signUp(req.getAccount(), req.getPwd(), req.getMemberName(), req.getMemberPhone()
				, req.getMemberEmail());
	}
	
	@PostMapping(value="member/member")
	public MemberGetRes member(@RequestParam int memberId) {
		return memberService.member(memberId);
	}
	
	@PostMapping(value="member/upDate")
	public MemberLoginRes upDate(@RequestParam int memberId,@RequestBody MemberUpDateReq req) {
		return memberService.upDate(memberId,req.getMemberName(),req.getMemberPhone(),req.getMemberEmail());
	}
	
	@PostMapping(value="member/pwdUpDate")
	public MemberLoginRes pwdUpDate(@RequestParam int memberId ,@RequestBody MemberPwdReq req) {
		return memberService.pwdUpDate(memberId,req.getPwd(),req.getNewPwd(),req.getConfirmPwd());
	}
}
