package com.toy.board.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.board.domain.member.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
