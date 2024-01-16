package com.example.XiaoLiuqiu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.entity.Employee;
import com.example.XiaoLiuqiu.entity.Member;
import com.example.XiaoLiuqiu.repository.EmployeeDAO;
import com.example.XiaoLiuqiu.service.ifs.EmployeeService;
import com.example.XiaoLiuqiu.vo.EmployeeGetRes;
import com.example.XiaoLiuqiu.vo.EmployeeLoginRes;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;

@Service
public class EmployeeServiceImpl implements EmployeeService {

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
	public EmployeeLoginRes login(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new EmployeeLoginRes(RtnCode.PARAM_ERROR);
		}
		Optional<Employee> op = employeeDao.findByAccount(account);
		if (op.isEmpty()) {
			return new EmployeeLoginRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		Employee employee = op.get();
		if (!encoder.matches(pwd, employee.getPwd())) {
			return new EmployeeLoginRes(RtnCode.ACCOUNT_NOT_FOUND);
		}
		return new EmployeeLoginRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public EmployeeLoginRes create(String account, String pwd) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new EmployeeLoginRes(RtnCode.PARAM_ERROR);
		}

		employeeDao.insertEmployee(account, encoder.encode(pwd));
		return new EmployeeLoginRes(RtnCode.SUCCESSFUL);
	}
	
	@Override
	public EmployeeLoginRes createMaster(String account, String pwd, boolean access) {
		if (!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new EmployeeLoginRes(RtnCode.PARAM_ERROR);
		}
		employeeDao.insertMaster(account, encoder.encode(pwd), access);
		return new EmployeeLoginRes(RtnCode.SUCCESSFUL);
	}

	@Override
	public EmployeeLoginRes update(int employeeId, String pwd, String newPwd, String confirmPwd) {
		if (employeeId <= 0) {
			return new EmployeeLoginRes(RtnCode.PARAM_ERROR);
		}
		Optional<Employee> op = employeeDao.findById(employeeId);
		if (op.isEmpty()) {
			return new EmployeeLoginRes(RtnCode.PWD_NOT_FOUMD);
		}
		Employee employee = op.get();
		if (!encoder.matches(pwd, employee.getPwd())) {
			return new EmployeeLoginRes(RtnCode.PWD_ERROR);
		}
		if (!newPwd.equals(confirmPwd)) {
			return new EmployeeLoginRes(RtnCode.NEW_PWD_ERROR);
		}

		employee.setPwd(encoder.encode(newPwd));
		employeeDao.save(employee);
		return new EmployeeLoginRes(RtnCode.SUCCESSFUL);
	}

}
