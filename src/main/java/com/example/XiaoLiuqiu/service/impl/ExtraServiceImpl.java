package com.example.XiaoLiuqiu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.repository.ExtraDAO;
import com.example.XiaoLiuqiu.service.ifs.ExtraService;
import com.example.XiaoLiuqiu.vo.ExtraRes;

public class ExtraServiceImpl implements ExtraService{
	
	@Autowired
	private ExtraDAO extraDao;

	@Override
	public ExtraRes create(String extraName, int extraPrice) {
		if(!StringUtils.hasText(extraName)||extraPrice<=0) {
			return new ExtraRes(RtnCode.PARAM_ERROR.getCode(),RtnCode.PARAM_ERROR.getMessage());
		}
		return null;
	}
	
	

}
