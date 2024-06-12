package com.toy.board.domain.post.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(name="post_image")
@SequenceGenerator( name = "POST_IMAGE_SEQ", initialValue = 1, allocationSize = 1) 
public class PostImage {
  
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POST_IMAGE_SEQ")
  private Long postImageId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(nullable = false, name = "post_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Post post;

  @Column(nullable = false)
  private String imageSrc;
}
