package com.tasty.board.service;

import java.util.List;

import com.tasty.board.dao.BoardDAO;
import com.tasty.board.model.Board;
import com.tasty.controller.ServiceInterface;

public class BoardListService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		List<Board> list = null; 
		BoardDAO dao = new BoardDAO();
		
		list = dao.list();
		
		return list;
	}

}
