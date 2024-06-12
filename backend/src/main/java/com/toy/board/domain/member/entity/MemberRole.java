package com.toy.board.domain.member.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="member_role")
@SequenceGenerator( name = "MEMBER_ROLE_SEQ", initialValue = 1, allocationSize = 1) 
public class MemberRole {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_ROLE_SEQ")
  private Long memberRoleId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, name = "member_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Member member;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, name = "role_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Role role;

}
