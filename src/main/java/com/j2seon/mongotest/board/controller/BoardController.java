package com.j2seon.mongotest.board.controller;

import com.j2seon.mongotest.base.common.ApiResult;
import com.j2seon.mongotest.board.dto.request.BoardReqDto;
import com.j2seon.mongotest.board.dto.request.UpdateBoardReqDto;
import com.j2seon.mongotest.board.dto.response.BoardResDto;
import com.j2seon.mongotest.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;

  @PostMapping("/boards")
  public ApiResult<BoardResDto> save (@RequestBody BoardReqDto reqDto) {
    return ApiResult.success(boardService.save(reqDto));
  }

  @GetMapping("/boards")
  public ApiResult<List<BoardResDto>> findByUsers (String userName) {
    return ApiResult.success(boardService.findByUsers(userName));
  }


  @PutMapping("/boards/{id}")
  public ApiResult<BoardResDto> update (@PathVariable String id, @RequestBody UpdateBoardReqDto reqDto) {
    return ApiResult.success(boardService.update(id, reqDto));
  }
}
