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

		while(true) {// 반복적인 메뉴출력을 위한 while
			Print.printTitle("맛집 이야기", "*");
			//모든이용자가 사용 가능한 메뉴출력
			Print.printMenu("1. 맛집리스트\t2. 맛집보기\n3. 맛집공유하기\n0. 이전 메뉴");
			PrintBoard out = null;//객체생성
			Object obj = null;//변수선언
			switch(new Input().inputInt()) {//메뉴선택을 입력받는다
			case 1://
				// 현재 게시되어있는 맛집리스트
				service = new BoardListService(); //생성
				obj = service.service(null);//호출및 변수에 저장
				out = new PrintBoard();//생성자 호출
				out.printList(obj);//변수를 넘겨받아 맛집리스트에 출력

				break;
			
			case 2:
				// 해당 맛집게시글 상세보기
				service = new BoardViewService();//생성
				service.service(null);//호출
				break;
				
			case 3:
				// 맛집공유하기(글쓰기)
				service = new BoardWriteService();//생성
				service.service(null);//호출
				break;
				
			case 0:
				// 이전 메뉴
				return;
				default :
					System.out.println("\n메뉴번호를 확인해주세요.");
			}
		}
	}
}
