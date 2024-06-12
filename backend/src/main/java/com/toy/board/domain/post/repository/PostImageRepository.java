package com.toy.board.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.board.domain.post.entity.PostImage;

public interface PostImageRepository extends JpaRepository<PostImage, Long>{

}
