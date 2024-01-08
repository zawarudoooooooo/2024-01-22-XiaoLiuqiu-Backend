package com.example.XiaoLiuqiu.service.ifs;

import com.example.XiaoLiuqiu.vo.MemberGetRes;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;

public interface MemberService {

	public MemberLoginRes login(String account , String pwd);
	
	public MemberLoginRes signUp(String account , String pwd , String memberName, 
			String memberPhone, String memberEmail);
	
//	public MemberLoginRes upDate(int memberId, String pwd , String memberName, 
//			String memberPhone, String memberEmail);
	
	public MemberGetRes member(int memberId);
}
