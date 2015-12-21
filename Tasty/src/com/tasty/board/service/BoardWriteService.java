package com.tasty.board.service;

import com.tasty.board.dao.BoardDAO;
import com.tasty.board.model.Board;
import com.tasty.controller.ServiceInterface;
import com.tasty.view.board.InputBoard;


public class BoardWriteService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		BoardDAO dao = new BoardDAO();
		InputBoard in = new InputBoard();
		
		Board board =new Board();
		board = in.inputWrite();
		
		dao.write(board);
		
		
		return null;
	}

}
