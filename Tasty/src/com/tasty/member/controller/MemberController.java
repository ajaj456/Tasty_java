package com.tasty.member.controller;

import com.tasty.controller.ControllerInterface;
import com.tasty.controller.ServiceInterface;
import com.tasty.member.model.Login;
import com.tasty.member.service.MemberDeleteService;
import com.tasty.member.service.MemberListService;
import com.tasty.member.service.MemberUpdateService;
import com.tasty.member.service.MemberViewService;
import com.tasty.util.Input;
import com.tasty.util.Print;

public class MemberController implements ControllerInterface {
	@Override
	public void process() {
		ServiceInterface service = null;
		
		while(true) {
			String menu;
			if(Login.grade == 9)
				menu = "2. 회원정보보기\n3. 회원정보수정";
			else
				menu = "2. 내정보보기\n3. 내정보수정";
			
			Print.printTitle("회원관리", "*");
			Print.printMenu("1. 회원리스트\t" + menu + "\t4. 회원탈퇴\n5. 비밀번호 변경\n0. 이전 메뉴");
			
			switch(Input.inputInt()) {
			case 1:
				// 회원리스트
				if(Login.grade == 9) {
					service = new MemberListService();
					service.service(null);
				}
				else
					System.out.println("관리자만 접근 가능합니다");
				break;
			
			case 2:
				// 정보보기
				service = new MemberViewService();
				if(Login.grade == 9) {
					service.service(null);
				}
				else
					service.service(Login.id);
				break;
				
			case 3:
				// 정보수정
				service = new MemberUpdateService();
				service.service("all");
				break;
				
			case 4:
				// 회원탈퇴
				service = new MemberDeleteService();
				service.service(null);
				break;
				
			case 5:
				// 비밀번호 변경
				service = new MemberUpdateService();
				service.service("pw");
				break;
				
			case 0:
				// 이전 메뉴
				return;
			}
		}
	}
}