package com.toy.board.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.board.domain.post.entity.PostLike;

public interface PostLikeRepository extends JpaRepository<PostLike, Long>{

}
