package com.toy.board.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.board.domain.post.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
  
}
