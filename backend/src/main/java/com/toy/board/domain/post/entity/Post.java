package com.toy.board.domain.post.entity;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.toy.board.domain.comment.entity.Comment;
import com.toy.board.domain.member.entity.Member;

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
@Table(name="post")
@SequenceGenerator( name = "POST_SEQ", initialValue = 1, allocationSize = 1) 
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_SEQ")
  private Long postId;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, name = "member_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Member member;

  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
  private List<Comment> comments;

  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
  private List<PostLike> postLikes;

  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
  private List<PostImage> postImages;
}
