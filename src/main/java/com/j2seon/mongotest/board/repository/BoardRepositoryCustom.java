package com.j2seon.mongotest.board.repository;

import com.j2seon.mongotest.board.entity.Board;
import com.j2seon.mongotest.user.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface BoardRepositoryCustom {

  Board test(String str);


}
