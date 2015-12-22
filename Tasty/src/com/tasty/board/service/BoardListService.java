package com.tasty.board.service;

import java.util.List;

import com.tasty.board.dao.BoardDao;
import com.tasty.board.dao.OracleBoardDao;
import com.tasty.board.model.Board;
import com.tasty.controller.ServiceInterface;

public class BoardListService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		List<Board> list = null; //
		BoardDao dao = new OracleBoardDao();//
		
		list = dao.list(); //dao에 list메소드의 결과값을 list에 저장
		
		return list;
	}

}
