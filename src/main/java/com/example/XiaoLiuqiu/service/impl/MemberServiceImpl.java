package com.example.XiaoLiuqiu.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Member;
import com.example.XiaoLiuqiu.repository.MemberDAO;
import com.example.XiaoLiuqiu.service.ifs.MemberService;
import com.example.XiaoLiuqiu.vo.MemberGetRes;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;


@Service
public class MemberServiceImpl implements MemberService {
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private JavaMailSender emailSender;

	@Override
	public MemberLoginRes login(String account, String pwd) {
		if(!StringUtils.hasText(account)||!StringUtils.hasText(pwd)) {
			return new MemberLoginRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage());
		}
		Optional<Member> op = memberDao.findByAccount(account);
		if(op.isEmpty()) {
			return new MemberLoginRes(RtnCode.ACCOUNT_NOT_FOUND.getCode(),RtnCode.ACCOUNT_NOT_FOUND.getMessage());
		}
		Member member=op.get();
		if(!encoder.matches(pwd, member.getPwd())) {
			return new MemberLoginRes(RtnCode.ACCOUNT_NOT_FOUND.getCode(),RtnCode.ACCOUNT_NOT_FOUND.getMessage());
		}
		
		return new MemberLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public MemberLoginRes signUp(String account, String pwd, String memberName, String memberPhone,
			String memberEmail) {
		if(!StringUtils.hasText(account)||!StringUtils.hasText(pwd)||!StringUtils.hasText(memberName)
				||!StringUtils.hasText(memberPhone)||!StringUtils.hasText(memberEmail)) {
			return new MemberLoginRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage());
		}
		if(memberDao.existsByAccount(account)) {
			return new MemberLoginRes(RtnCode.ACCOUNT_EXISTED.getCode(),RtnCode.ACCOUNT_EXISTED.getMessage());
		}
		memberDao.save(new Member(account,encoder.encode(pwd), memberName, memberPhone, memberEmail));
		return new MemberLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public MemberGetRes member(String account) {
		
		if(!StringUtils.hasText(account)) {
			return new MemberGetRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage(),null);
		}
		List<Member> res=memberDao.findByAcc(account);
		return new MemberGetRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage(),res);
		
//		if(memberId<=0) {
//			return new MemberGetRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage(),null);
//		}
		
//		List<Member> res=memberDao.findByMemberId(memberId);
//		
		
	}

	@Override
	public MemberLoginRes upDate(int memberId, String memberName, String memberPhone, String memberEmail) {
		if(memberId<=0) {
			return new MemberLoginRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage());
		}
		Optional<Member> op= memberDao.findById(memberId);
		if(op.isEmpty()) {
			return new MemberLoginRes(RtnCode.MEMBER_NOT_FOUMD.getCode(),RtnCode.MEMBER_NOT_FOUMD.getMessage());
		}
		Member member=op.get();
		if(StringUtils.hasText(memberName)) {
			member.setMemberName(memberName);
		}
		if(StringUtils.hasText(memberPhone)) {
			member.setMemberPhone(memberPhone);
		}
		if(StringUtils.hasText(memberEmail)) {
			member.setMemberEmail(memberEmail);
		}
		memberDao.save(member);
		return new MemberLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public MemberLoginRes pwdUpDate(int memberId,String pwd,String newPwd,String confirmPwd) {
		if(memberId<=0) {
			return new MemberLoginRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage());
		}
		Optional<Member> op = memberDao.findById(memberId);
		if(op.isEmpty()) {
			return new MemberLoginRes(RtnCode.PWD_NOT_FOUMD.getCode(),RtnCode.PWD_NOT_FOUMD.getMessage());
		}
		Member member =op.get();
		if(!encoder.matches(pwd, member.getPwd())) {
			return new MemberLoginRes(RtnCode.PWD_ERROR.getCode(),RtnCode.PWD_ERROR.getMessage());
		}
		if(!newPwd.equals(confirmPwd)) {
			return new MemberLoginRes(RtnCode.NEW_PWD_ERROR.getCode(),RtnCode.NEW_PWD_ERROR.getMessage());
		}
		if(!confirmPwd.equals(newPwd)) {
			return new MemberLoginRes(RtnCode.NEW_PWD_ERROR.getCode(),RtnCode.NEW_PWD_ERROR.getMessage());
		}
		member.setPwd(encoder.encode(newPwd));
		memberDao.save(member);
		return new MemberLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage());
	}

	@Override
	public MemberLoginRes sendResetPasswordEmail(String account) {
		 if (!StringUtils.hasText(account)) {
	            return new MemberLoginRes(RtnCode.PARAM_ERROR.getCode(), RtnCode.PARAM_ERROR.getMessage());
	        }

	        Member member = memberDao.findByAccount(account).orElse(null);
	        if (member == null) {
	            return new MemberLoginRes(RtnCode.ACCOUNT_NOT_FOUND.getCode(), RtnCode.ACCOUNT_NOT_FOUND.getMessage());
	        }

	        // 生成重置碼
	        String resetCode = UUID.randomUUID().toString();
	        member.setRestCode(resetCode);
	        memberDao.save(member);

	        // 發送郵件
	        sendResetPasswordEmail(account, resetCode);

	        return new MemberLoginRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage());
	}
	private void sendResetPasswordEmail(String account, String resetCode) {
	        String to = "xiaoliuqiu0122@gmail.com"; // 修改為實際的郵件接收者地址
	        String subject = "重置密碼";
	        String text = "請點擊以下連結重置密碼:\n" +
	                "http://localhost:5173/reset_password?account=" + account + "&resetCode=" + resetCode;

	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(text);
	        emailSender.send(message);
	    }

//	@Override
//	public MemberGetRes member1(String account) {
//		if(!StringUtils.hasText(account)) {
//			return new MemberGetRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage(),null);
//		}
//		Optional<Member> op = memberDao.findByAccount(account);
//		if(op.isEmpty()) {
//			return new MemberGetRes(RtnCode.ACCOUNT_NOT_FOUND.getCode(),RtnCode.ACCOUNT_NOT_FOUND.getMessage(),null);
//		}
//		Member member=op.get();
//		List<Member> res=member.getAccount();
//		return new MemberGetRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage(),res);
//		return null;
//	}

	

	

	

	

	

}
