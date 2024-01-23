package com.j2seon.mongotest.base.exception.domain;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

  private final ErrorCodeInterFace errorCode;
  private final String errorMessage;

  public BaseException(ErrorCodeInterFace errorCode) {
    this.errorCode = errorCode;
    this.errorMessage = errorCode.getErrorMessage();
  }

  public BaseException(ErrorCodeInterFace errorCode, String errorMessage){
    super(errorMessage);
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

}
