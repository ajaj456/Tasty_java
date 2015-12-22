package com.tasty.notice.sevice;

import com.tasty.controller.ServiceInterface;
import com.tasty.exception.NoticeNotFoundException;
import com.tasty.member.model.Login;
import com.tasty.notice.dao.NoticeDao;
import com.tasty.notice.dao.OracleNoticeDao;
import com.tasty.notice.model.Notice;
import com.tasty.util.Input;
import com.tasty.util.Print;
import com.tasty.view.notice.PrintNotice;

public class NoticeViewService implements ServiceInterface {
	ServiceInterface service = null;

	@Override
	public Object service(Object obj) {
		NoticeDao dao = new OracleNoticeDao(); // 생성 및 호출
		Notice notice;
		while (true) {
			int no = Input.inputInt("글번호를 입력해주세요");
			notice = dao.view(no);
			// 없는 글번호를 호출하면 오류메세지가 아닌 다른 메세지를 호출하게 하는 익셉션처리
			try { 
				checkNull(notice); // 익셉션처리의 조건()
			} catch (NoticeNotFoundException e) {
				System.out.println(e.getMessage());
				return null;
			}
			PrintNotice out = new PrintNotice(); // 객체 생성 및 호출
			out.Print(notice); // 출력
			Print.printTitle("메뉴", "*");
			Print.printMenu("1. 글수정\t2. 글삭제\n0. 이전 메뉴");
			// 메뉴처리를 위한 switch문
			switch (Input.inputInt()) {
			case 1: // 글수정
				// 관리자만 접근할 수 있도록 하는 처리문
				if (Login.grade == 9) {
					service = new NoticeUpdateService(); // 생성 및 호출
					service.service(no);
				} else
					System.out.println("접근 권한이 없습니다.");
				break;
			case 2:// 글삭제
				// 관리자만 접근할 수 있도록 하는 처리문
				if (Login.grade == 9) {
					service = new NoticeDeleteService(); // 생성 및 호출
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
    // 익셉션 처리를 위한 메소드(조건을 줄)
	private void checkNull(Notice notice) throws NoticeNotFoundException {
		if(notice == null)
			throw new NoticeNotFoundException();
	}
}