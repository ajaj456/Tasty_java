package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.exception.MemberNotFoundException;
import com.tasty.exception.WrongNumInputException;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.member.model.Login;
import com.tasty.member.model.Member;
import com.tasty.util.Input;
import com.tasty.util.Print;
import com.tasty.view.member.PrintMember;

public class MemberViewService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		ServiceInterface service = null;
		
		MemberDao dao = new OracleMemberDao();
		Member member;
		String id;
		PrintMember out = new PrintMember();
		
		if(obj == null)
			id = Input.inputString("아이디");
		else
			id = (String)obj;
		
		while(true) {
			member = dao.view(id);
			
			try {
				checkNull(member);
			} catch (MemberNotFoundException e) {
				return null;
			}
			
			out.print(member);
			
			String menu;
			if(Login.grade == 9)
				menu = "1. 회원정보수정";
			else
				menu = "1. 내정보수정";
			
			Print.printTitle("회원관리", "*");
			Print.printMenu(menu + "\t2. 비밀번호 변경\n3. 회원탈퇴\n0. 이전 메뉴");
			
			int num = -1;
			try {
				num = Input.inputInt();
			} catch (WrongNumInputException e) {
				System.out.println(e.getMessage());
			}
			
			switch(num) {
			case 1:
				service = new MemberUpdateService();
				service.service(member);
				break;
				
			case 2:
				service = new MemberUpdatePwService();
				service.service(member);
				break;
				
			case 3:
				service = new MemberDeleteService();
				int state = (Integer) service.service(member);
				
				if(state == 1) {
					service = new LogoutService();
					service.service(null);
				}
				return null;
				
			case 0:
				return null;
			}
		}
	}

	private void checkNull(Member member) throws MemberNotFoundException {
		if(member == null)
			throw new MemberNotFoundException();
	}
}
