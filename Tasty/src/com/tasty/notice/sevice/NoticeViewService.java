package com.tasty.notice.sevice;

import com.tasty.controller.ServiceInterface;
import com.tasty.notice.dao.NoticeDao;
import com.tasty.notice.view.PrintView;
import com.tasty.util.Input;
import com.tasty.util.Print;

public class NoticeViewService implements ServiceInterface {
	ServiceInterface service = null;

	@Override
	public Object service(Object obj) {
		NoticeDao dao = new NoticeDao();
		int no = Input.inputInt("글번호를 입력해주세요");
		obj = dao.view(no);
		PrintView out = new PrintView();
		while (true) {
		out.print(obj);
		Print.printTitle("메뉴", "*");
		Print.printMenu("1. 글수정\t2. 글삭제\n0. 이전 메뉴");
			switch (Input.inputInt()) {
			case 1:
				// 맛집리스트
				service = new NoticeUpdateService();
				service.service(no);
				break;
			case 2:
				// 글삭제 
				service = new NoticeDeleteService();
				service.service(no);
				return null;
			case 0:
				// 이전 메뉴
				return null;
			}
		}

	}
}