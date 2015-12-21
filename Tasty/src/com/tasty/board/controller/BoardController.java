package com.tasty.board.controller;


import com.tasty.board.service.BoardListService;
import com.tasty.board.service.BoardViewService;
import com.tasty.board.service.BoardWriteService;
import com.tasty.controller.ControllerInterface;
import com.tasty.controller.ServiceInterface;
import com.tasty.util.Input;
import com.tasty.util.Print;
import com.tasty.view.board.PrintBoard;





public class BoardController implements ControllerInterface {
	ServiceInterface service = null;
	
	@Override
	public void process() {

		while(true) {
			Print.printTitle("맛집 이야기", "*");
			Print.printMenu("1. 글리스트\t2. 글보기\n3. 글쓰기\n0. 이전 메뉴");
			PrintBoard out = null;
			Object obj = null;
			switch(new Input().inputInt()) {
			case 1:
				// 글리스트
				service = new BoardListService();
				obj = service.service(null);
				out = new PrintBoard();
				out.printList(obj);

				break;
			
			case 2:
				// 글보기
				service = new BoardViewService();
				service.service(null);
				break;
				
			case 3:
				// 글쓰기
				service = new BoardWriteService();
				service.service(null);
				break;
				
			case 0:
				// 이전 메뉴
				return;
			}
		}
	}
}
