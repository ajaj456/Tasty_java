package com.tasty.notice.sevice;

import com.tasty.controller.ServiceInterface;
import com.tasty.exception.NoticeNotFoundException;
import com.tasty.member.model.Login;
import com.tasty.notice.dao.NoticeDao;
import com.tasty.notice.model.Notice;
import com.tasty.util.Input;
import com.tasty.util.Print;
import com.tasty.view.notice.PrintNotice;

public class NoticeViewService implements ServiceInterface {
	ServiceInterface service = null;

	@Override
	public Object service(Object obj) {
		NoticeDao dao = new NoticeDao();
		Notice notice;
		while (true) {
			int no = Input.inputInt("글번호를 입력해주세요");
			notice = dao.view(no);
			try {
				checkNull(notice); // 공지글
			} catch (NoticeNotFoundException e) {
				System.out.println(e.getMessage());
				return null;
			}
			PrintNotice out = new PrintNotice();
			out.Print(notice);
			Print.printTitle("메뉴", "*");
			Print.printMenu("1. 글수정\t2. 글삭제\n0. 이전 메뉴");
			switch (Input.inputInt()) {
			case 1:
				// 글수정
				if (Login.grade == 9) {
					service = new NoticeUpdateService();
					service.service(no);
				} else
					System.out.println("접근 권한이 없습니다.");
				break;
			case 2:
				// 글삭제
				if (Login.grade == 9) {
					service = new NoticeDeleteService();
					service.service(no);
				} else
					System.out.println("접근 권한이 없습니다.");
				return null;
			case 0:
				// 이전 메뉴
				return null;
			}
		}

	}

	private void checkNull(Notice notice) throws NoticeNotFoundException {
		if(notice == null)
			throw new NoticeNotFoundException();
	}
}