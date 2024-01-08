package com.example.XiaoLiuqiu.service.ifs;

import com.example.XiaoLiuqiu.vo.MemberLoginRes;

public interface MemberService {

	public MemberLoginRes login(String account , String pwd);
	
	public MemberLoginRes signUp(String account , String pwd , String memberName, 
			String memberPhone, String memberEmail);
}
