package com.j2seon.mongotest.board.entity;

import com.j2seon.mongotest.user.entity.Users;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Document(collection = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
  @Id
  private String id;
  private String title;
  private String content;

  @DocumentReference(lookup = "{ _id : ?#{#target} }")
  private Users users;

  @Builder
  public Board(String title, String content, Users users) {
    this.title = title;
    this.content = content;
    this.users = users;
  }
}