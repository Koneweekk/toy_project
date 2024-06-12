package com.toy.board.domain.member.service;

import org.springframework.stereotype.Service;

import com.toy.board.domain.member.dto.request.MemberJoinDto;
import com.toy.board.domain.member.entity.Member;
import com.toy.board.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
  
  private final MemberRepository memberRepository;

  public void createMember(MemberJoinDto memberJoinDto) {
    Member member = Member.builder()
                                .email(memberJoinDto.getEmail())
                                .password(memberJoinDto.getPassword())
                                .name(memberJoinDto.getName())
                                .build();

    memberRepository.save(member);
  }
}
