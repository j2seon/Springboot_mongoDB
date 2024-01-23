package com.j2seon.mongotest.base.exception.error;

import com.j2seon.mongotest.base.exception.domain.ErrorCodeInterFace;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ErrorCodeInterFace {

  USER_NOT_FOUND(400 , "사용자를 찾을 수 없음.")
  ;

  private Integer errorCode;
  private String errorMessage;


}
