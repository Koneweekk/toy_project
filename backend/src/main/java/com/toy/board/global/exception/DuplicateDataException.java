package com.toy.board.global.exception;

public class DuplicateDataException extends RuntimeException{
  public DuplicateDataException() {
    super("이미 존재하는 데이터입니다.");
  }

  public DuplicateDataException(String message) {
    super(message);
  }
}
