package com.tasty.controller;

import com.tasty.board.controller.BoardController;
import com.tasty.member.controller.MemberController;
import com.tasty.notice.controller.NoticeController;
import com.tasty.qna.controller.QnaController;
import com.tasty.util.Input;
import com.tasty.util.Print;

public class Main {
	public static void main(String[] args) {
		ControllerInterface controller = null;
		
		while(true) {
			Print.printTitle("맛집을 찾아서", "*");
			Print.printMenu("1. 로그인/로그아웃\t2. 오늘의 맛집\n3. 맛집 이야기\t\t4. 질문게시판\n5. 회원관리\n0. 종료");
			
			switch(new Input().inputInt()) {
			case 1:
				// 로그인/로그아웃
				break;
			
			case 2:
				// 오늘의 맛집
				controller = new NoticeController();
				controller.process();
				break;
				
			case 3:
				// 맛집 이야기
				controller = new BoardController();
				controller.process();
				break;
				
			case 4:
				// 질문게시판
				controller = new QnaController();
				controller.process();
				break;
				
			case 5:
				// 회원관리
				controller = new MemberController();
				controller.process();
				break;
				
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
