package com.j2seon.mongotest.board.dto.request;

import lombok.Builder;

public record BoardReqDto(
  String title,
  String content,
  String author
) {

  @Builder
  public BoardReqDto {
  }

}
