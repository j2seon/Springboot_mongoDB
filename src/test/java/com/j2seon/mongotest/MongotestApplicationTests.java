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

@EnableAutoConfiguration
@SpringBootTest
class MongotestApplicationTests {

	@Autowired private BoardRepository boardRepository;
	@Autowired private UsersRepository usersRepository;


	@Test
	void contextLoads() {

		Board board1 = Board.builder().title("test1").content("test1111111111").build();
		Users users = usersRepository.findByLoginId("test").orElseThrow(() -> new BaseException(BaseErrorCode.NULL_POINT));

		boardRepository.save(board1);
		users.addBoard(board1);

		System.out.println(users.getBoards().get(0).getTitle());
	}

}
