package com.example.XiaoLiuqiu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Employee;
import com.example.XiaoLiuqiu.repository.EmployeeDAO;
import com.example.XiaoLiuqiu.service.ifs.EmployeeService;
import com.example.XiaoLiuqiu.vo.EmployeeGetRes;
import com.example.XiaoLiuqiu.vo.EmployeeRes;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	public EmployeeGetRes search(String account) {
		account = !StringUtils.hasText(account) ? "" : account;
		List<Employee> res = employeeDao.findByAccountContaining(account);
		return new EmployeeGetRes(RtnCode.SUCCESSFUL, res);
	}

	@Override
	public EmployeeRes login(String account, String pwd) {
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new EmployeeRes(RtnCode.PARAM_ERROR);
		}
		Optional<Employee> op = employeeDao.findByAccount(account);
		if(op.isEmpty()) {
			return new EmployeeRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		Employee employee = op.get();
		if(!encoder.matches(pwd, employee.getPwd())) {
			return new EmployeeRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		return new EmployeeRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public EmployeeRes create(String account, String pwd) {
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new EmployeeRes(RtnCode.PARAM_ERROR);
		}
		employeeDao.insertEmployee(account, encoder.encode(pwd));
		return new EmployeeRes(RtnCode.SUCCESSFUL);
	}
	
	

}
