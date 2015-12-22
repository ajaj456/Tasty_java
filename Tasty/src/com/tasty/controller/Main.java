package com.tasty.controller;

import com.tasty.board.controller.BoardController;
import com.tasty.exception.WrongNumInputException;
import com.tasty.member.controller.MemberController;
import com.tasty.member.model.Login;
import com.tasty.member.model.Member;
import com.tasty.member.service.FindService;
import com.tasty.member.service.LoginService;
import com.tasty.member.service.LogoutService;
import com.tasty.member.service.MemberViewService;
import com.tasty.member.service.MemberWriteService;
import com.tasty.notice.controller.NoticeController;
import com.tasty.qna.controller.QnaController;
import com.tasty.util.Input;
import com.tasty.util.Print;

public class Main {
	public static void main(String[] args) {
		ControllerInterface controller = null;
		ServiceInterface service = null;
		
		String menu1;
		String menu2;
		
		while(true) {
			// 로그인 되어있을 때 화면 출력
			if(Login.id != null) {
				// 로그인한 계정의 이름을 출력
				Print.printTitle(Login.name + "님 반갑습니다", "=");
				// 로그인 되어있을 때 로그아웃 출력
				menu1 = "1. 로그아웃";
				if(Login.grade == 9)
					menu2 = "5. 회원관리"; // 관리자일 때 회원관리 출력
				else
					menu2 = "5. 마이페이지"; // 일반회원일 때 마이페이지 출력
			}
			else { // 로그인 되어있지 않을 때 기본화면 출력
				menu1 = "1. 로그인";
				menu2 = "5. 회원가입\n6. 아이디 찾기\t7. 비밀번호 찾기";
			}
			
			Print.printTitle("동규의 이대 맛집", "*"); // 타이틀 출력
			Print.printMenu(menu1 + "\t2. 오늘의 맛집\n3. 맛집 이야기\t4. 질문게시판\n" + menu2 + "\n0. 종료"); // 메뉴 출력
			
			// 메뉴를 고르는 숫자를 입력받는다
			// 글자 등 잘못 입력하면 에러 발생
			int num = -1;
			try {
				num = Input.inputInt(); 
			} catch (WrongNumInputException e) {
				System.out.println(e.getMessage());
			}
			// 입력받은 숫자에 따른 메뉴 선택
			switch(num) {
			case 1:
				// 로그인/로그아웃
				if(Login.id != null) { // 로그인 되어있으면 로그아웃 실행
					service = new LogoutService();
					service.service(null);
				}
				else { // 로그인 되어있지 않으면 로그인 실행
					service = new LoginService();
					service.service(null);
				}
				break;
			
			case 2:
				// 오늘의 맛집(공지사항)
				controller = new NoticeController();
				controller.process();
				break;
				
			case 3:
				// 맛집 이야기(자유게시판)
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
				if(Login.id != null) { // 로그인 되어있으면 
					if(Login.grade == 9) { // 관리자일때 멤버컨트롤러 실행
						controller = new MemberController();
						controller.process();
					}
					else { // 일반회원일때 자신의 정보만 볼수 있게 viewService 실행
						service = new MemberViewService();
						service.service(Login.id);
					}
				}
				
				else { // 로그인 되어있지 않으면 회원가입
					service = new MemberWriteService();
					Member member = (Member) service.service(null);
					service = new LoginService(); // 회원가입을 하면 자동으로 로그인 진행
					service.service(member);
				}
				break;
				
			case 6:
				// 아이디 찾기
				service = new FindService();
				service.service("id");
				break;
				
			case 7:
				// 비밀번호 찾기
				service = new FindService();
				service.service("pw");
				break;
				
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
				
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
}
