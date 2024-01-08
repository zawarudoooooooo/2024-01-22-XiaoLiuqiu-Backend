package com.example.XiaoLiuqiu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.XiaoLiuqiu.entity.Member;


@Repository
public interface MemberDAO extends JpaRepository<Member, String> {

}
