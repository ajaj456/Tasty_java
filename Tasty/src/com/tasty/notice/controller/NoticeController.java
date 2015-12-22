/*
 * 공지게시판을 총괄 관리하는 controller
 */
package com.tasty.notice.controller;

import com.tasty.controller.ControllerInterface;
import com.tasty.controller.ServiceInterface;
import com.tasty.member.model.Login;
import com.tasty.notice.sevice.NoticeListService;
import com.tasty.notice.sevice.NoticeViewService;
import com.tasty.notice.sevice.NoticeWriteService;
import com.tasty.util.Input;
import com.tasty.util.Print;
import com.tasty.view.notice.PrintNotice;

public class NoticeController implements ControllerInterface {
	ServiceInterface service = null;

	@Override
	public void process() {
		// 관리자만 볼수있는 메뉴를 출력하기 위한 처리
		String menu;
		// 관리자면 아래의 메뉴가 더 추가되서 나온다.
		if (Login.grade == 9)
			menu = "3. 맛집추가\t4. 지난 맛집\n5. 새로운 맛집\t6. 모든 맛집\n";
		else
			menu = "";
		while (true) { // 반복적인 메뉴출력을 위한 while
			Print.printTitle("오늘의 맛집", "*");
			Print.printMenu("1. 맛집리스트\t2. 맛집보기\n" + menu + "0. 이전 메뉴");
			// 관리자가 아니면 기본 메뉴리스트만 나온다.
			PrintNotice out = null; // 객체생성
			Object obj = null; // 변수선언
			switch (Input.inputInt()) { // 메뉴선택을 입력받음.
			case 1: // 현재공지되고 있는 맛집리스트
				service = new NoticeListService(); // 생성
				obj = service.service("now"); // ()호출 및 변수에 저장
				out = new PrintNotice(); // 생성자호출
				out.printList(obj); // 변수를 넘겨받아 글리스트를 출력
				break;
			case 2:
				// 게시중인 맛집보기
				service = new NoticeViewService(); // 생성
				service.service(null); // ()호출
				break;
			case 3:
				if (Login.grade == 9) { // 관리자가 아닌 일반인은 맛집 추가를 할 수 없음
					// 맛집추가
					service = new NoticeWriteService(); // 생성
					service.service(null); // ()호출
				} else
					System.out.println("접근 권한이 없습니다."); // 일반인이 접근할 경우 출력
				break;
			case 4:
				if (Login.grade == 9) { // 관리자가 아닌 일반인은 맛집 추가를 할 수 없음
					// 지난 맛집
					service = new NoticeListService();// 생성
					obj = service.service("old"); // old값을 받아 생긴 결과값을 obj에 저장
					out = new PrintNotice(); // 생성
					out.printList(obj); // 변수를 넘겨받아 글리스트를 출력
				} else
					System.out.println("접근 권한이 없습니다."); // 일반인이 접근할 경우 출력
				break;
			case 5:
				if (Login.grade == 9) { // 관리자가 아닌 일반인은 맛집 추가를 할 수 없음
					// 새로운 맛집
					service = new NoticeListService();// 생성
					obj = service.service("new");// new값을 받아 생긴 결과값을 obj에 저장
					out = new PrintNotice(); // 생성
					out.printList(obj); // 변수를 넘겨받아 글리스트를 출력
				} else
					System.out.println("접근 권한이 없습니다."); // 일반인이 접근할 경우 출력
				break;
			case 6:
				if (Login.grade == 9) { // 관리자가 아닌 일반인은 맛집 추가를 할 수 없음
					// 모든 맛집
					service = new NoticeListService();// 생성
					obj = service.service("all");// all값을 받아 생긴 결과값을 obj에 저장
					out = new PrintNotice(); // 생성
					out.printList(obj); //변수를 넘겨받아 글리스트를 출력
				} else
					System.out.println("접근 권한이 없습니다."); // 일반인이 접근할 경우 출력
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
