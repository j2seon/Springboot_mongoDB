package com.j2seon.mongotest.base.common;

import com.j2seon.mongotest.base.exception.domain.ErrorCodeInterFace;

public record ApiResult<T>(
  boolean success,
  T data,
  Error error
) {

  public static <T> ApiResult<T> success(T data) {
    return new ApiResult<>(true, data, null);
  }

  public static <T> ApiResult<T> fail(ErrorCodeInterFace errorCode, T data) {
    return new ApiResult<>(false, data, new Error(errorCode.getErrorCode(), errorCode.getErrorMessage()));
  }

  public static <T> ApiResult<T> fail(ErrorCodeInterFace errorCode, String message) {
    return new ApiResult<>(false, null, new Error(errorCode.getErrorCode(), message));
  }

  public static <T> ApiResult<T> fail(ErrorCodeInterFace errorCode) {
    return new ApiResult<>(false, null, new Error(errorCode.getErrorCode(), errorCode.getErrorMessage()));
  }

  public static <T> ApiResult<T> fail(Integer errorCode, String message) {
    return new ApiResult<>(false, null, new Error(errorCode, message));
  }
  public record Error(
    Integer errorCode,
    String message
  ) {
  }

}
