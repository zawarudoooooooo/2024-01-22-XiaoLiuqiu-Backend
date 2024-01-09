package com.example.XiaoLiuqiu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Member;
import com.example.XiaoLiuqiu.repository.MemberDAO;
import com.example.XiaoLiuqiu.service.ifs.MemberService;
import com.example.XiaoLiuqiu.vo.MemberGetRes;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;
import com.example.XiaoLiuqiu.vo.MemberPwdReq;


@Service
public class MemberServiceImpl implements MemberService {
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	@Autowired
	private MemberDAO memberDao;

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
	public MemberGetRes member(int memberId) {
		if(memberId<=0) {
			return new MemberGetRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage(),null);
		}
		List<Member> res=memberDao.findByMemberId(memberId);
		return new MemberGetRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage(),res);
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

	

	

	

	

	

}
