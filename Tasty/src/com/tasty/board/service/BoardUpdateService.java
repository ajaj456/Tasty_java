package com.tasty.board.service;

import com.tasty.board.dao.BoardDao;
import com.tasty.board.model.Board;
import com.tasty.controller.ServiceInterface;
import com.tasty.view.board.InputBoard;


public class BoardUpdateService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		BoardDao dao  = new BoardDao();
		InputBoard in = new InputBoard();
		System.out.println("\n수정할 내용을 입력해 주세요!");
		
		Board board = new Board();
		board = in.inputWrite();
		board.setNo((int)obj);
		
		dao.update(board);
		return board;
		
	}

}
