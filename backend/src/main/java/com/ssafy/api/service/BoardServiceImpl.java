package com.ssafy.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.BoardRequest;
import com.ssafy.db.entity.Board;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.BoardRepository;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardRepository boardRepository;
	


	@Override
	public Board createBoard(BoardRequest boardRegisterInfo) {
		Board board = new Board();
		board.setCategoryLarge(boardRegisterInfo.getCategoryLarge());
		board.setCategoryMiddle(boardRegisterInfo.getCategoryMiddle());
		board.setContent(boardRegisterInfo.getContent());
		board.setImg(boardRegisterInfo.getImg());
		board.setTitle(boardRegisterInfo.getTitle());
		board.setUserUid(boardRegisterInfo.getUserUid());
		board.setRegTime(boardRegisterInfo.getRegTime());
		board.setViewCount(0);

		return boardRepository.save(board);
	}

	@Override
	public Board readBoardByUid(BoardRequest boardRegisterInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board updateBoard(BoardRequest boardRegisterInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board deleteBoardByNickname(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board postBoardByUsersNickname(int uid) {
		// TODO Auto-generated method stub
		return null;
	}
}
