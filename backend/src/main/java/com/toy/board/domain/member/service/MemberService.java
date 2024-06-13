package com.toy.board.domain.member.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.toy.board.domain.member.dto.request.MemberJoinDto;
import com.toy.board.domain.member.dto.request.MemberLoginDto;
import com.toy.board.domain.member.dto.response.MemberMyinfoDto;
import com.toy.board.domain.member.entity.Member;
import com.toy.board.domain.member.repository.MemberRepository;
import com.toy.board.global.exception.DuplicateDataException;
import com.toy.board.global.exception.NotExistException;
import com.toy.board.global.exception.UnAuthorizedException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
  
  private final MemberRepository memberRepository;

  public void signup(MemberJoinDto memberJoinDto) {
    boolean isExisted = memberRepository.findByEmail(memberJoinDto.getEmail()).isPresent();

    if (isExisted) {
      throw new DuplicateDataException("이미 등록된 이메일입니다.");
    } else {
      Member member = Member.builder()
      .email(memberJoinDto.getEmail())
      .password(memberJoinDto.getPassword())
      .name(memberJoinDto.getName())
      .build();

      memberRepository.save(member);
    }
  }

  public MemberMyinfoDto login(MemberLoginDto memberLoginDto) {
    Optional<Member> member = memberRepository.findByEmail(memberLoginDto.getEmail());
    if (!member.isPresent()) {
      throw new NotExistException("등록되지 않은 이메일입니다.");
    } 

    Member currentMember = member.get();
    if (!member.get().getPassword().equals(memberLoginDto.getPassword())) {
      throw new UnAuthorizedException("비밀번호를 확인해주세요.");
    }

    MemberMyinfoDto memberMyinfoDto = MemberMyinfoDto.builder()
                                                    .memberId(currentMember.getMemberId())
                                                    .email(currentMember.getEmail())
                                                    .name(currentMember.getName())
                                                    .imageSrc(currentMember.getImageSrc())
                                                    .build();

    return memberMyinfoDto;
  } 
}
