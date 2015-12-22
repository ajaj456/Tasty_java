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

// 회원정보보기 서비스
public class MemberViewService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		ServiceInterface service = null;
		
		MemberDao dao = new OracleMemberDao();
		Member member;
		String id;
		PrintMember out = new PrintMember();
		
		if(obj == null) // 관리자일때는 원하는 회원의 정보를 입력받아서 본다 
			id = Input.inputString("아이디");
		else // 일반회원일때는 자기 자신의 정보를 본다
			id = (String)obj;
		
		while(true) {
			member = dao.view(id); // 회원의 정보를 가져온다
			
			try {
				checkNull(member); // 해당하는 회원의 정보를 가져와서 회원정보 유무를 확인
			} catch (MemberNotFoundException e) {
				return null;
			}
			
			out.print(member); // 회원정보 출력
			
			String menu;
			if(Login.grade == 9) // 관리자일 때 회원정보수정 메뉴 
				menu = "1. 회원정보수정";
			else // 일반회원일 때 내정보수정 메뉴
				menu = "1. 내정보수정";
			
			Print.printTitle("회원관리", "*"); // 타이틀 출력
			Print.printMenu(menu + "\t2. 비밀번호 변경\n3. 회원탈퇴\n0. 이전 메뉴"); // 메뉴 출력
			
			int num = -1;
			try {
				num = Input.inputInt(); // 입력받은 게 숫자인지 확인하고 Exception 발생
			} catch (WrongNumInputException e) {
				System.out.println(e.getMessage());
			}
			
			switch(num) { // 입력받은 숫자에 따라 메뉴 선택
			case 1:
				// 회원정보수정 / 내정보수정
				service = new MemberUpdateService();
				service.service(member);
				break;
				
			case 2:
				// 비밀번호 변경
				service = new MemberUpdatePwService();
				service.service(member);
				break;
				
			case 3:
				// 회원탈퇴
				service = new MemberDeleteService();
				int state = (Integer) service.service(member); // 회원탈퇴가 정상적으로 이루어져 있는지 리턴받은 확인값 저장
				
				if(state == 1) { // 회원탈퇴가 정상적으로 이루어졌으면
					service = new LogoutService(); // 로그아웃서비스 실행
					service.service(null);
				}
				return null;
				
			case 0:
				// 이전 메뉴
				return null;
				
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}

	private void checkNull(Member member) throws MemberNotFoundException {
		if(member == null) // 회원의 정보가 없으면 Exception 발생
			throw new MemberNotFoundException();
	}
}
