package com.tasty.notice.controller;

import com.tasty.controller.ControllerInterface;
import com.tasty.controller.ServiceInterface;
import com.tasty.notice.sevice.NoticeListService;
import com.tasty.notice.sevice.NoticeViewService;
import com.tasty.notice.sevice.NoticeWriteService;
import com.tasty.util.Input;
import com.tasty.util.Print;

public class NoticeController implements ControllerInterface {
	ServiceInterface service = null;

	@Override
	public void process() {
		while (true) {
			Print.printTitle("오늘의 맛집", "*");
			Print.printMenu("1. 맛집리스트\t2. 맛집보기\n3. 맛집추가\t4. 지난 맛집\n5. 새로운 맛집\t6. 모든 맛집\n0. 이전 메뉴");

			switch (Input.inputInt()) {
			case 1:
				// 맛집리스트
				service = new NoticeListService();
				service.service("now");
				break;
			case 2:
				// 맛집보기
				service = new NoticeViewService();
				service.service(null);
				break;
			case 3:
				// 맛집추가
				service = new NoticeWriteService();
				service.service(null);
				break;
			case 4:
				// 지난 맛집
				service = new NoticeListService();
				service.service("old");
				break;
			case 5:
				// 새로운 맛집
				service = new NoticeListService();
				service.service("new");
				break;
			case 6:
				// 모든 맛집
				service = new NoticeListService();
				service.service("all");
				break;
			case 0:
				// 이전 메뉴
				return;
			}
		}
	}
}
