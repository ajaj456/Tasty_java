package com.tasty.member.controller;

import com.tasty.controller.ControllerInterface;
import com.tasty.controller.ServiceInterface;
import com.tasty.exception.WrongNumInputException;
import com.tasty.member.model.Login;
import com.tasty.member.service.MemberListService;
import com.tasty.member.service.MemberViewService;
import com.tasty.util.Input;
import com.tasty.util.Print;

public class MemberController implements ControllerInterface {
	@Override
	public void process() {
		ServiceInterface service = null; // 서비스 인터페이스 정의
		
		while(true) {
			// 회원등급(관리자, 일반회원)에 따른 메뉴 표시 화면 변경
			String menu;
			if(Login.grade == 9)
				// 관리자
				menu = "1. 회원정보보기\t2. 회원리스트";
			else
				// 일반회원
				menu = "1. 내정보보기";
			
			// 타이틀 화면 출력
			Print.printTitle("회원관리", "*");
			// 메뉴 화면 출력
			Print.printMenu(menu + "\n0. 이전 메뉴");
			
			// 입력받는 숫자에 따른 메뉴 선택
			int num = -1;
			
			try {
				num = Input.inputInt();
			} catch (WrongNumInputException e) {
				System.out.println(e.getMessage());
			}
			
			switch(num) {
			case 1:
				// 정보보기
				service = new MemberViewService();
				// 회원등급(관리자,일반회원)에 따라 다른 메뉴 실행
				if(Login.grade == 9) {
					// 관리자
					service.service(null);
				}
				else
					// 일반회원
					service.service(Login.id);
				break;
			
			case 2:
				// 회원리스트
				// 회원등급(관리자,일반회원)에 따라 다른 메뉴 실행
				if(Login.grade == 9) {
					// 관리자
					service = new MemberListService();
					service.service(null);
				}
				else
					// 일반회원
					System.out.println("관리자만 접근 가능합니다");
				break;
				
			case 0:
				// 이전 메뉴
				return;
			}
		}
	}
}