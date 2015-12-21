package com.tasty.board.service;

import com.tasty.board.dao.BoardDAO;
import com.tasty.controller.ServiceInterface;


public class BoardDeleteService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		int no = (Integer)obj;
		// DB에서 글번호에 맞는 글을 삭제한다.
		BoardDAO dao = new BoardDAO();
		dao.delete(no);
		
		return null;
	}

}
