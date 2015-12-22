package com.tasty.board.service;

import com.tasty.board.dao.BoardDao;
import com.tasty.board.dao.OracleBoardDao;
import com.tasty.board.model.Board;
import com.tasty.controller.ServiceInterface;
import com.tasty.view.board.InputBoard;


public class BoardWriteService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		BoardDao dao = new OracleBoardDao();// 생성 및 호출
		InputBoard in = new InputBoard();
		
		Board board =new Board();
		board = in.inputWrite();//입력한 글을board변수에 저장
		
		dao.write(board);//dao객체를 통해 메소드 처리
		
		
		return null;
	}

}
