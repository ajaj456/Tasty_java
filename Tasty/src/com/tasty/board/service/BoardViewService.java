package com.tasty.board.service;

import com.tasty.board.dao.BoardDao;
import com.tasty.board.dao.OracleBoardDao;
import com.tasty.board.model.Board;
import com.tasty.controller.ServiceInterface;
import com.tasty.exception.BoardNotFoundException;
import com.tasty.util.Input;
import com.tasty.util.Print;
import com.tasty.view.board.PrintBoard;

public class BoardViewService implements ServiceInterface {

	ServiceInterface service = null;

	@Override
	public Object service(Object obj) {
		BoardDao dao = new OracleBoardDao();
		int no = Input.inputInt("글번호를 입력하세요");
		PrintBoard out = new PrintBoard();
		while (true) {
			Board board = dao.view(no); 
			
			try {
				checkNull(board);
			} catch (BoardNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			out.Print(board);
			Print.printTitle("메뉴", "*");
			Print.printMenu("1. 글수정\t2. 글삭제\n0. 이전 메뉴");
			switch (Input.inputInt()) {
			case 1:
				// 글수정
				service = new BoardUpdateService();
				service.service(no);
				break;
			case 2:
				// 글삭제
				service = new BoardDeleteService();
				service.service(no);
				return null;
			case 0:
				// 이전 메뉴
				return null;
			}
		}
	}
	
	private void checkNull(Board board) throws BoardNotFoundException {
		if(board == null)
			throw new BoardNotFoundException();
	}
}
