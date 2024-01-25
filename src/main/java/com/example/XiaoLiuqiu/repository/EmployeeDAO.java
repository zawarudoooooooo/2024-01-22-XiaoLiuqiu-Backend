package com.example.XiaoLiuqiu.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.XiaoLiuqiu.constants.Department;
import com.example.XiaoLiuqiu.entity.Employee;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	
	@Transactional(rollbackOn = Exception.class)
	@Modifying
	@Query(value = "insert into employee(account, password)"
			+ "select :account, :password "
			+ "where not exists (select 1 from employee where account = :account)",		
	nativeQuery = true)
	public int insertEmployee(//
			@Param("account")String account,//
			@Param("password")String pwd);
	
	@Transactional(rollbackOn = Exception.class)
	@Modifying
	@Query(value = "insert into employee(account, password, access)"
			+ "select :account, :password, :access "
			+ "where not exists (select 1 from employee where account = :account)",		
	nativeQuery = true)
	public int insertMaster(//
			@Param("account")String account,//
			@Param("password")String pwd,
			@Param("access")int access);
	
	public Optional<Employee> findByAccount(String account);
	
	public List<Employee> findByAccountContaining(String account);
	
	public List<Employee> findByDepartmentAndActive(Department department, boolean active);
	
	public List<Employee> findAllByActive(boolean active);
	
	public List<Employee> findByAccountAndActive(String account, boolean active);
	
	public List<Employee> findAll();
	
	@Query(value="select * from employee where account = :account", nativeQuery = true)
	public Employee findByAccount2(@Param("account")String account);
	
	public boolean existsByAccount(String account);
	
	@Transactional(rollbackOn = Exception.class)
	@Modifying
	@Query(value = "update employee set password = :password where account = :account", nativeQuery = true)
	public int updatePassword(//
			@Param("account")String account,//
			@Param("password")String pwd);
	
	
	@Query(value="select * from employee where account = :account", nativeQuery = true)
	public List<Employee> findByAcc(@Param("account")String account);
	

}
