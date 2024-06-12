package com.toy.board.domain.comment.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.toy.board.domain.member.entity.Member;
import com.toy.board.domain.post.entity.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name="comments")
@SequenceGenerator( name = "COMMENT_SEQ",  initialValue = 1, allocationSize = 1) 
public class Comment {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_SEQ")
  private Long commentId;

  @Column(nullable = false)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, name = "post_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Post post;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, name="member_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Member member;

  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = true, name="parent_comment_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Comment parentComment;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentComment")
  private List<Comment> childComments;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "comment")
  private List<CommentLike> commentLikes;

}
