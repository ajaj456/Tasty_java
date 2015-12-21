package com.tasty.member.controller;

import com.tasty.controller.ControllerInterface;
import com.tasty.controller.ServiceInterface;
import com.tasty.member.model.Login;
import com.tasty.member.service.MemberListService;
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
				menu = "1. 회원정보보기\t2. 회원리스트";
			else
				menu = "1. 내정보보기";
			
			Print.printTitle("회원관리", "*");
			Print.printMenu(menu + "\n0. 이전 메뉴");
			
			switch(Input.inputInt()) {
			case 1:
				// 정보보기
				service = new MemberViewService();
				if(Login.grade == 9) {
					service.service(null);
				}
				else
					service.service(Login.id);
				break;
			
			case 2:
				// 회원리스트
				if(Login.grade == 9) {
					service = new MemberListService();
					service.service(null);
				}
				else
					System.out.println("관리자만 접근 가능합니다");
				break;
				
			case 0:
				// 이전 메뉴
				return;
			}
		}
	}
}