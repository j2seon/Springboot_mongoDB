package com.j2seon.mongotest.base.exception;

import com.j2seon.mongotest.base.exception.domain.BaseException;
import com.j2seon.mongotest.base.common.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {
  @ExceptionHandler(BaseException.class)
  public ApiResult<Void> baseException(BaseException e){
    System.out.println("ExceptionHandler - baseException :"+e.getErrorCode());
    return ApiResult.fail(e.getErrorCode(), e.getErrorMessage());
  }


}
