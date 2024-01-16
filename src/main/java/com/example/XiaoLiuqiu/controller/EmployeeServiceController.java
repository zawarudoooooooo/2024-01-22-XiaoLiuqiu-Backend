package com.example.XiaoLiuqiu.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.XiaoLiuqiu.constants.RtnCode;
import com.example.XiaoLiuqiu.service.ifs.EmployeeService;
import com.example.XiaoLiuqiu.vo.EmployeeGetRes;
import com.example.XiaoLiuqiu.vo.EmployeeLoginReq;
import com.example.XiaoLiuqiu.vo.EmployeeLoginRes;
import com.example.XiaoLiuqiu.vo.EmployeeReq;
import com.example.XiaoLiuqiu.vo.EmployeeUpdateReq;
import com.example.XiaoLiuqiu.vo.MemberLoginRes;

@CrossOrigin
@RestController
public class EmployeeServiceController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "employee/search")
	public EmployeeGetRes search(@RequestBody EmployeeReq req) {
		return employeeService.search(req.getAccount());
	}
	
	@PostMapping(value = "employee/login")
	public EmployeeLoginRes login(@RequestBody EmployeeLoginReq req, HttpSession session ,HttpServletResponse response) {
//		System.out.println(session.getId());
		String attr = (String)session.getAttribute("account");
		if(StringUtils.hasText(attr) && attr.equals(req.getAccount())) {
			return new EmployeeLoginRes(RtnCode.SUCCESSFUL);
		}
		EmployeeLoginRes res = employeeService.login(req.getAccount(), req.getPwd());
		if(res.getRtncode().getCode() == 200) {
			session.setAttribute("account", req.getAccount());
			Cookie memberIdCookie = new Cookie("employee", req.getAccount());
			memberIdCookie.setMaxAge(600); 
			memberIdCookie.setPath("/");
            response.addCookie(memberIdCookie);
		}
		return res;
	}
	
	@PostMapping(value="employee/logout")
	public MemberLoginRes logout(HttpSession session ,HttpServletResponse response) {
		Cookie employeeCookie = new Cookie("employee", "");
		employeeCookie.setMaxAge(0); 
		employeeCookie.setPath("/");
        response.addCookie(employeeCookie);
		
		session.invalidate();
		System.out.println(session.getId());
		return new MemberLoginRes(RtnCode.SUCCESSFUL.getCode(),RtnCode.SUCCESSFUL.getMessage()) ;
		
	}
	
	@PostMapping(value = "employee/createMaster")
	public EmployeeLoginRes createMaster(@RequestBody EmployeeReq req) {
		return employeeService.create(req.getAccount(), req.getPwd(), req.isAccess());
	}
	
	@PostMapping(value = "employee/create")
	public EmployeeLoginRes create(@RequestBody EmployeeReq req) {
		return employeeService.create(req.getAccount(), req.getPwd());
	}
	
	@PostMapping(value = "employee/update")
	public EmployeeLoginRes update(@RequestParam int employeeId, @RequestBody EmployeeUpdateReq req) {
		return employeeService.update(employeeId, req.getPwd(), req.getNewPwd(), req.getConfirmPwd());
	}

}
