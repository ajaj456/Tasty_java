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
		String menu;
		if (Login.grade == 9)
			menu = "3. 맛집추가\t4. 지난 맛집\n5. 새로운 맛집\t6. 모든 맛집\n";
		else
			menu = "";

		while (true) {
			Print.printTitle("오늘의 맛집", "*");
			Print.printMenu("1. 맛집리스트\t2. 맛집보기\n" + menu + "0. 이전 메뉴");
			PrintNotice out = null;
			Object obj = null;
			switch (Input.inputInt()) {
			case 1:
				// 맛집리스트
				service = new NoticeListService();
				obj = service.service("now");
				out = new PrintNotice();
				out.printList(obj);
				break;
			case 2:
				// 맛집보기
				service = new NoticeViewService();
				service.service(null);
				break;
			case 3:
				if (Login.grade == 9) {
					// 맛집추가
					service = new NoticeWriteService();
					service.service(null);
				} else
					System.out.println("접근 권한이 없습니다.");
				break;
			case 4:
				if (Login.grade == 9) {
					// 지난 맛집
					service = new NoticeListService();
					obj = service.service("old");
					out = new PrintNotice();
					out.printList(obj);
				} else
					System.out.println("접근 권한이 없습니다.");
				break;
			case 5:
				if (Login.grade == 9) {
					// 새로운 맛집
					service = new NoticeListService();
					obj = service.service("new");
					out = new PrintNotice();
					out.printList(obj);
				} else
					System.out.println("접근 권한이 없습니다.");
				break;
			case 6:
				if (Login.grade == 9) {
					// 모든 맛집
					service = new NoticeListService();
					obj = service.service("all");
					out = new PrintNotice();
					out.printList(obj);
				} else
					System.out.println("접근 권한이 없습니다.");
				break;
			case 0:
				// 이전 메뉴
				return;
			}
		}
	}
}
