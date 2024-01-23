package com.j2seon.mongotest.base.exception.error;

import com.j2seon.mongotest.base.exception.domain.ErrorCodeInterFace;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum BaseErrorCode implements ErrorCodeInterFace {

  BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "잘못된 요청"),
  SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(),  "서버 에러"),
  NULL_POINT(HttpStatus.INTERNAL_SERVER_ERROR.value(),  "Null point"),
  FORBIDDEN(HttpStatus.FORBIDDEN.value(), "인증 실패");

  private Integer errorCode;
  private String errorMessage;

}
