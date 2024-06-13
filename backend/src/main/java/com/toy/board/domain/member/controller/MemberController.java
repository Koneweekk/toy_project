package com.toy.board.domain.member.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.toy.board.domain.member.dto.request.MemberJoinDto;
import com.toy.board.domain.member.dto.request.MemberLoginDto;
import com.toy.board.domain.member.dto.response.MemberMyinfoDto;
import com.toy.board.domain.member.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

  private final MemberService memberService;

  @PostMapping("/login")
  public ResponseEntity<MemberMyinfoDto> login(@RequestBody @Valid MemberLoginDto memberLoginDto) {
      MemberMyinfoDto memberMyinfoDto = memberService.login(memberLoginDto);
      
      return ResponseEntity.status(HttpStatus.OK).body(memberMyinfoDto);
  }
  

  @PostMapping("/signup")
  public ResponseEntity<String> signup(@RequestBody @Valid MemberJoinDto memberJoinDto) {
    memberService.signup(memberJoinDto);

    return ResponseEntity.status(HttpStatus.CREATED).body("회원가입완료");
  }
  
}
