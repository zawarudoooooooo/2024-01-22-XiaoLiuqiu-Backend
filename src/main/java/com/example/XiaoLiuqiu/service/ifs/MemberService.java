package com.example.XiaoLiuqiu.service.ifs;

import com.example.XiaoLiuqiu.vo.MemberGetRes;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;

public interface MemberService {

	public MemberLoginRes login(String account , String pwd);
	
	public MemberLoginRes signUp(String account , String pwd , String memberName, 
			String memberPhone, String memberEmail);
	
	public MemberLoginRes upDate(int memberId, String memberName, 
			String memberPhone, String memberEmail);
	
	public MemberLoginRes pwdUpDate(int memberId,String pwd,String newPwd,String confirmPwd);
	
	public MemberGetRes member(String account);
	
//	public MemberGetRes member1(String account);
}
