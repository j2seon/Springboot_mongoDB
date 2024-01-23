package com.j2seon.mongotest.board.dto.response;

import lombok.Builder;

public record BoardResDto (
  String title,
  String author
) {

  @Builder
  public BoardResDto {
  }
}
