package com.toy.board.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.board.domain.member.entity.MemberRole;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Long>{

}
