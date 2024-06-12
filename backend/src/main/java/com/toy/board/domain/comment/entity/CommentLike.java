package com.toy.board.domain.comment.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.toy.board.domain.member.entity.Member;

import jakarta.persistence.Column;
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
@Table(name="comment_like")
@SequenceGenerator( name = "COMMENT_LIKE_SEQ", initialValue = 1, allocationSize = 1) 
public class CommentLike {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_LIKE_SEQ")
  private Long commentLikeId;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = true, name = "member_id")
  @OnDelete(action = OnDeleteAction.SET_NULL)
  private Member member;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, name = "comment_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Comment comment;

  @Column(nullable = false)
  private Boolean isLike;
}
