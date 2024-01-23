package com.j2seon.mongotest.user.service;

import com.j2seon.mongotest.base.exception.domain.BaseException;
import com.j2seon.mongotest.base.exception.error.UserErrorCode;
import com.j2seon.mongotest.user.dto.request.UserReqDTO;
import com.j2seon.mongotest.user.dto.response.UserResDTO;
import com.j2seon.mongotest.user.entity.Users;
import com.j2seon.mongotest.user.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

  private final UsersRepository usersRepository;

  public UserResDTO getUser(String loginId){
    Users users = usersRepository.findByLoginId(loginId).orElseThrow(() -> new BaseException(UserErrorCode.USER_NOT_FOUND));

    return UserResDTO.builder()
            .loginId(users.getLoginId())
            .userName(users.getUserName())
            .build();
  }

  public UserResDTO save (UserReqDTO userDto) {
    Users entity = userDto.toEntity();
    System.out.println(entity.getLoginId());
    Users saveUser = usersRepository.save(entity);
    return UserResDTO.builder()
            .loginId(saveUser.getLoginId())
            .userName(saveUser.getUserName())
            .build();
  }


}
