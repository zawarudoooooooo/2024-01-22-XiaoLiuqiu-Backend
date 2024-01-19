package com.example.XiaoLiuqiu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.XiaoLiuqiu.service.ifs.MemberService;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;

@SpringBootTest
class MemberServiceTest {
	
	@Autowired
	public MemberService memberService;

//	@Test
//	public void signUpTest() {
//		MemberLoginRes res=memberService.signUp("aa123", "b55688", "¤ý¾å©ú", "0912345678", "j3139915@gmail.com");
//		System.out.println(res.getCode()+res.getMessage());
//	}
	@Test
	public void signUpTest1() {
		MemberLoginRes res=memberService.login("aa123", "b55688");
		System.out.println(res.getCode()+res.getMessage());
	}
	
	@Test
	public void coookie() {
		
	}
}
