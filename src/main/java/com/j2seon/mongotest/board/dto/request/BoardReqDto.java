package com.j2seon.mongotest.board.dto.request;

import com.j2seon.mongotest.board.entity.Board;
import lombok.Builder;

public record BoardReqDto(
  String title,
  String content,
  String author
) {

}
