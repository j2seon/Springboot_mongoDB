package com.j2seon.mongotest.board.service;

import com.j2seon.mongotest.base.exception.domain.BaseException;
import com.j2seon.mongotest.base.exception.domain.ErrorCodeInterFace;
import com.j2seon.mongotest.base.exception.error.BaseErrorCode;
import com.j2seon.mongotest.base.exception.error.UserErrorCode;
import com.j2seon.mongotest.board.dto.request.BoardReqDto;
import com.j2seon.mongotest.board.dto.request.UpdateBoardReqDto;
import com.j2seon.mongotest.board.dto.response.BoardResDto;
import com.j2seon.mongotest.board.entity.Board;
import com.j2seon.mongotest.board.repository.BoardRepository;
import com.j2seon.mongotest.user.entity.Users;
import com.j2seon.mongotest.user.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;
  private final UsersRepository usersRepository;

  public BoardResDto save(BoardReqDto reqDto) {

    Users users = usersRepository.findByLoginId(reqDto.author()).orElseThrow(() -> new BaseException(UserErrorCode.USER_NOT_FOUND));
    Board newBoard = Board.builder()
                          .title(reqDto.title())
                          .content(reqDto.content())
                          .users(users)
                          .build();

    boardRepository.save(newBoard);
    users.addBoard(newBoard);

    return BoardResDto.builder()
      .title(newBoard.getTitle())
      .author(newBoard.getUsers().getUserName())
      .build();
  }

  public List<BoardResDto> findByUsers(String username){
    Users users = usersRepository.findByLoginId(username).orElseThrow(() -> new BaseException(UserErrorCode.USER_NOT_FOUND));
    List<Board> findBoard = boardRepository.findByUsers(users);
    List<BoardResDto> result = findBoard.stream().map(data -> BoardResDto.builder()
        .title(data.getTitle())
        .author(data.getUsers().getLoginId())
        .build())
      .toList();

    return result;
  }

  public BoardResDto update(String id, @RequestBody UpdateBoardReqDto reqDto){

    Board findBoard = boardRepository.findById(id).orElseThrow(() -> new BaseException(BaseErrorCode.NULL_POINT));

    Board newBoard = findBoard.updateEntity(reqDto);

    boardRepository.save(newBoard);

    return BoardResDto.builder()
      .title(newBoard.getTitle())
      .author(newBoard.getUsers().getLoginId())
      .build();
  }



}
