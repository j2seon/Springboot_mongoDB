package com.j2seon.mongotest.user.controller;

import com.j2seon.mongotest.base.common.ApiResult;
import com.j2seon.mongotest.user.dto.request.UserReqDTO;
import com.j2seon.mongotest.user.dto.response.UserResDTO;
import com.j2seon.mongotest.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UsersController {

  private final UsersService usersService;

  @GetMapping("/users/{loginId}")
  public ApiResult<UserResDTO> findOne(@PathVariable String loginId){
    UserResDTO user = usersService.getUser(loginId);
    return ApiResult.success(user);
  }

  @PostMapping("/users")
  public ApiResult<UserResDTO> register(@RequestBody UserReqDTO userReqDTO){
    System.out.println(userReqDTO);
    UserResDTO save = usersService.save(userReqDTO);
    return ApiResult.success(save);
  }


}
