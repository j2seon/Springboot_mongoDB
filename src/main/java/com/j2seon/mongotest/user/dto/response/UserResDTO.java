package com.j2seon.mongotest.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



public record UserResDTO(
  String loginId,
  String userName
  ) {
  @Builder
  public UserResDTO {}
}
