package com.example.XiaoLiuqiu.vo;

import java.util.List;

import com.example.XiaoLiuqiu.entity.Member;

public class MemberGetRes extends MemberLoginRes {

	private List<Member> memberList;

	public MemberGetRes(int code, String message,List<Member> memberList) {
		super(code, message);
		this.memberList = memberList;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}
	
}
