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
		BoardDao dao = new OracleBoardDao();//생성 및 호출
		int no = Input.inputInt("글번호를 입력하세요");
		PrintBoard out = new PrintBoard();
		while (true) {
			Board board = dao.view(no); 
			//없는 글번호를 호출하면 오류메세지가 아닌 다른 메세지를 호출하게 하는 익셉션 처리
			try {
				checkNull(board);//익셉션 처리의 조건()
			} catch (BoardNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			out.Print(board);//출력
			Print.printTitle("메뉴", "*");
			Print.printMenu("1. 글수정\t2. 글삭제\n0. 이전 메뉴");
			//메뉴처리를 위한 switch문 
			switch (Input.inputInt()) {
			case 1:
				// 글수정
				service = new BoardUpdateService();//생성
				service.service(no);//호출
				break;
			case 2:
				// 글삭제
				service = new BoardDeleteService();//생성
				service.service(no);//호출
				return null;
			case 0:
				// 이전 메뉴
				return null;
			}
		}
	}
	// 익셉션 처리를 위한 메소드(조건을 줄)
	private void checkNull(Board board) throws BoardNotFoundException {
		if(board == null)
			throw new BoardNotFoundException();
	}
}
