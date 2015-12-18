package com.tasty.notice.sevice;

import com.tasty.controller.ServiceInterface;
import com.tasty.notice.dao.NoticeDao;
import com.tasty.util.Print;

public class NoticeListService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		
		NoticeDao dao = new NoticeDao();
		dao.list(obj);
		Print.printTitle("맛집리스트", "*");
		listGuideline();
		System.out.println("| 1 | 이대맛집 | KFC | 2015-12-18 | 2015-12-15 | 2015-12-31 |");
		
		return null;
	}

	private void listGuideline() {
		// TODO Auto-generated method stub
		System.out.println("| 글번호 | 글제목 | 글내용 | 작성일 | 시작일 | 종료일 |");
		
	}

}
