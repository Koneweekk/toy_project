package com.toy.board.domain.member.entity;

import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import com.toy.board.domain.comment.entity.Comment;
import com.toy.board.domain.comment.entity.CommentLike;
import com.toy.board.domain.post.entity.Post;
import com.toy.board.domain.post.entity.PostLike;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="member")
@DynamicInsert
@SequenceGenerator( name = "MEMBER_SEQ", initialValue = 1, allocationSize = 1)
public class Member {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ")
  private Long memberId;

  @Column(nullable=false, unique=true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  @ColumnDefault("'https://koneweekk-toy-bucket.s3.ap-northeast-2.amazonaws.com/profile/default_profile.jpg'")
  private String imageSrc;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
  private List<MemberRole> memberRoles;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
  private List<Post> posts;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
  private List<PostLike> postLikes;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
  private List<Comment> comments;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
  private List<CommentLike> commentLikes;

}
