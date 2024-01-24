package com.j2seon.mongotest.user.entity;

import com.j2seon.mongotest.board.entity.Board;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users {

  @Id
  private String userId;
  private String loginId;
  private String password;
  private String userName;

  // @ReadOnlyProperty
  @DocumentReference(lazy = true)
  private List<Board> boards ;

  @Builder
  public Users(String loginId, String password, String userName) {
    this.loginId = loginId;
    this.password = password;
    this.userName = userName;
  }

  public void addBoard(Board board){
    this.boards.add(board);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Users users = (Users) o;
    return Objects.equals(userId, users.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId);
  }
}
