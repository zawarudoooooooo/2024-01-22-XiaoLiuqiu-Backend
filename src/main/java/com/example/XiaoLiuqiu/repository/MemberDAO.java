package com.example.XiaoLiuqiu.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.XiaoLiuqiu.entity.Member;


@Repository
public interface MemberDAO extends JpaRepository<Member, String> {

	public boolean  existsByAccount(String accout);
	
	public Optional<Member> findByAccount(String account);
}
