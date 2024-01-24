package com.j2seon.mongotest.board.dto.request;

import lombok.Builder;

public record UpdateBoardReqDto(
  String title,
  String content
) {


}
