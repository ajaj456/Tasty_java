package com.tasty.board.service;

import com.tasty.board.dao.BoardDao;
import com.tasty.board.dao.OracleBoardDao;
import com.tasty.board.model.Board;
import com.tasty.controller.ServiceInterface;
import com.tasty.view.board.InputBoard;


public class BoardUpdateService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		Board board = (Board)obj;
		BoardDao dao  = new OracleBoardDao();//생성및 호출
		InputBoard in = new InputBoard();//생성및 호출
		in.inputUpdateData(board);
		dao.update(board); //dao객체를 통해 메소드 처리
		return board;
		
	}

}
