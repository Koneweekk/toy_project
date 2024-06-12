package com.toy.board.domain.member.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class MemberJoinDto {

  // @Email(message = "유효한 이메일 형식이 아닙니다.")
  // @NotBlank(message = "이메일은 필수 입력값입니다.")
  private String email;

  // @NotBlank(message = "비밀번호는 필수 입력값입니다.")
  private String password;

  // @NotBlank(message = "이름은 필수 입력값입니다.")
  private String name;
}
