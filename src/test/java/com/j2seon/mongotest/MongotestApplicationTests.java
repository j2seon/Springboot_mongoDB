package com.j2seon.mongotest;

import com.j2seon.mongotest.base.exception.domain.BaseException;
import com.j2seon.mongotest.base.exception.error.BaseErrorCode;
import com.j2seon.mongotest.board.entity.Board;
import com.j2seon.mongotest.board.repository.BoardRepository;
import com.j2seon.mongotest.user.entity.Users;
import com.j2seon.mongotest.user.repository.UsersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@EnableAutoConfiguration
@SpringBootTest
class MongotestApplicationTests {

	@Autowired private BoardRepository boardRepository;
	@Autowired private UsersRepository usersRepository;

	@Test
	void contextLoads() {

		Users users = usersRepository.findByLoginId("test").orElseThrow(() -> new BaseException(BaseErrorCode.NULL_POINT));
		List<Board> byUsers = boardRepository.findByUsers(users);
		System.out.println("테스트:"+ byUsers.get(0).getContent());



	}

}
