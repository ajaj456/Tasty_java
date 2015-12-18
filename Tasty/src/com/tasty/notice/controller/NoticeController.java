package com.tasty.notice.controller;

import com.tasty.controller.ControllerInterface;
import com.tasty.util.Input;
import com.tasty.util.Print;

public class NoticeController implements ControllerInterface {
	@Override
	public void process() {
		while(true) {
			Print.printTitle("오늘의 맛집", "*");
			Print.printMenu("1. 맛집리스트\t2. 맛집보기\n3. 맛집추가\t4. 지난 맛집\n5. 예약 맛집\t6. 모든 맛집\n0. 이전 메뉴");
			
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
