package com.j2seon.mongotest.user.dto.request;

import com.j2seon.mongotest.user.dto.response.UserResDTO;
import com.j2seon.mongotest.user.entity.Users;
import lombok.Builder;

public record UserReqDTO(
  String loginId,
  String userName,
  String password
) {

  @Builder
  public UserReqDTO {
  }

  public Users toEntity (){
    return Users.builder()
            .loginId(this.loginId)
            .password(this.password)
            .userName(this.userName)
            .build();
  }
}
