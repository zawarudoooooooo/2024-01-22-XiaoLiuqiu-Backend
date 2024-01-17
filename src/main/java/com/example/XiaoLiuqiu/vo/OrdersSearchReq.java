package com.example.XiaoLiuqiu.vo;

import java.time.LocalDate;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrdersSearchReq {

	@Column(name = "member_name")
	private String memberName;
	
	@JsonProperty(value = "start_date")
	private LocalDate startDate;
	
	@JsonProperty(value = "end_date")
	private LocalDate endDate;

	public OrdersSearchReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersSearchReq(String memberName, LocalDate startDate, LocalDate endDate) {
		super();
		this.memberName = memberName;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	
	
	
}
