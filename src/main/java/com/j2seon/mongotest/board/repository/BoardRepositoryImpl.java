package com.j2seon.mongotest.board.repository;

import com.j2seon.mongotest.board.entity.Board;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.j2seon.mongotest.board.entity.QBoard.board;

@Repository
public class BoardRepositoryImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom {

  public BoardRepositoryImpl(MongoOperations operations) {
    super(operations);
  }

  @Override
  public Board test(String str) {
    return from(board)
              .where(board.title.eq(str))
              .fetchOne();
  }
}
