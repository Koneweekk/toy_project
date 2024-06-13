package com.toy.board.domain.member.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberMyinfoDto {

  private Long memberId;
  private String email;
  private String name;
  private String imageSrc;

}
