package com.tasty.member.controller;

import com.tasty.controller.ControllerInterface;
import com.tasty.util.Input;
import com.tasty.util.Print;

public class MemberController implements ControllerInterface {
	@Override
	public void process() {
		while(true) {
			Print.printTitle("회원관리", "*");
			Print.printMenu("1. 회원리스트\t\t2. 회원정보보기\n3. 회원정보수정\t\t4. 회원탈퇴\n5. 비밀번호 변경\t6. 아이디 찾기\n0. 비밀번호 찾기");
			
			switch(new Input().inputInt()) {
			case 1:
				// 맛집리스트
				break;
			
			case 2:
				// 맛집보기
				break;
				
			case 3:
				// 맛집추가
				break;
				
			case 4:
				// 지난 맛집
				break;
				
			case 5:
				// 예약 맛집
				break;
				
			case 6:
				// 모든 맛집
				break;
				
			case 0:
				// 이전 메뉴
				return;
			}
		}
	}
}