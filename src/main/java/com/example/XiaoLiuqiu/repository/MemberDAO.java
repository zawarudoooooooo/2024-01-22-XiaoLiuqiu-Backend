package com.example.XiaoLiuqiu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.XiaoLiuqiu.entity.Member;


@Repository
public interface MemberDAO extends JpaRepository<Member, Integer> {

	public boolean  existsByAccount(String accout);
	
	public Optional<Member> findByMemberEmail(String memberEmail);
	
	public Optional<Member> findByAccount(String account);
	
	public List<Member> findByMemberId(int memberId);
	
	public Optional<Member> findByMemberName(String memberName);
	
	public Optional<Member> findByPwd(String pwd);
	
	@Query(value="select * from member where account = :account", nativeQuery = true)
	public List<Member> findByAcc(@Param("account")String account);
	
	public boolean existsByMemberEmail(String memberEmail);
	
	public Optional<Member> findByMemberEmailAndVerificationCode(String memberEmail, String verificationCode);
	
}
