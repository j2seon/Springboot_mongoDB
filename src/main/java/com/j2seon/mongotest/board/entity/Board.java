package com.j2seon.mongotest.board.entity;

import com.j2seon.mongotest.board.dto.request.UpdateBoardReqDto;
import com.j2seon.mongotest.user.entity.Users;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Entity
@Document(collection = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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


  public Board updateEntity(UpdateBoardReqDto dto) {
      return new Board(this.getId(),dto.title(),dto.content(),this.getUsers());
  }
}