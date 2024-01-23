package com.j2seon.mongotest.board.repository;

import com.j2seon.mongotest.board.entity.Board;
import com.j2seon.mongotest.user.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BoardRepository extends MongoRepository<Board, String> {

  List<Board> findByUsers(Users users);
}
