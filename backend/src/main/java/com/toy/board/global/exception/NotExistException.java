package com.toy.board.global.exception;

public class NotExistException extends RuntimeException{
  public NotExistException() {
    super("해당 데이터는 존재하지 않습니다.");
  }

  public NotExistException(String message) {
    super(message);
  }
}
