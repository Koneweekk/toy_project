package com.toy.board.domain.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.board.domain.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
