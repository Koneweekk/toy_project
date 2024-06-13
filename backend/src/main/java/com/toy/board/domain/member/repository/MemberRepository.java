package com.toy.board.domain.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.board.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
  
  public Optional<Member> findByEmail(String email);
}
