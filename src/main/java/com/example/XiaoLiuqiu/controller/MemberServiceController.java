package com.example.XiaoLiuqiu.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Member;
import com.example.XiaoLiuqiu.repository.MemberDAO;
import com.example.XiaoLiuqiu.service.ifs.MemberService;
import com.example.XiaoLiuqiu.vo.MemberGetRes;
import com.example.XiaoLiuqiu.vo.MemberLoginReq;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;
import com.example.XiaoLiuqiu.vo.MemberPwdReq;
import com.example.XiaoLiuqiu.vo.MemberResetPwdReq;
import com.example.XiaoLiuqiu.vo.MemberSignUpReq;
import com.example.XiaoLiuqiu.vo.MemberUpDateReq;

@CrossOrigin
@RestController
public class MemberServiceController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberDAO memberDao;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	
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
		
		System.out.println(session.getId());
		return res;
	}
	@PostMapping(value="member/signUp")
	public MemberLoginRes signUp(@RequestBody MemberSignUpReq req) {
		return memberService.signUp(req.getAccount(), req.getPwd(), req.getMemberName(), req.getMemberPhone()
				, req.getMemberEmail());
	}
	
	@PostMapping(value="member/member")
	public MemberGetRes member(@RequestParam String account) {
		return memberService.member(account);
	}
	
	@PostMapping(value="member/upDate")
	public MemberLoginRes upDate(@RequestParam int memberId,@RequestBody MemberUpDateReq req) {
		return memberService.upDate(memberId,req.getMemberName(),req.getMemberPhone(),req.getMemberEmail());
	}
	
	@PostMapping(value="member/pwdUpDate")
	public MemberLoginRes pwdUpDate(@RequestParam int memberId ,@RequestBody MemberPwdReq req) {
		return memberService.pwdUpDate(memberId,req.getPwd(),req.getNewPwd(),req.getConfirmPwd());
	}
	
	@PostMapping(value="member/send_email")
	public MemberLoginRes sendEmail(@RequestBody MemberSignUpReq req) {
		return memberService.sendResetPasswordEmail(req.getAccount());
	}
	
	@PostMapping(value="member/reset_password")
	public  MemberLoginRes resetPassword(@RequestParam String account, @RequestParam String resetCode, @RequestBody MemberResetPwdReq req) {
		 return memberService.restPwd(account, resetCode, req.getNewPwd(), req.getConfirmPwd());
	}
	
	 @PostMapping(value = "member/verify")
	 public ResponseEntity<String> verifyAccount(@RequestParam String memberEmail, @RequestParam String verificationCode) {
		 
		 boolean isVerified = memberService.verifyAccount(memberEmail, verificationCode);
		 
		 if(isVerified) {
			 return new ResponseEntity<>("帳號驗證成功", HttpStatus.OK);
		 } else {
			 return new ResponseEntity<>("帳號驗證失敗", HttpStatus.BAD_REQUEST);
		 }		 
	 }
}
