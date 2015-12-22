package com.tasty.notice.sevice;

import java.util.List;

import com.tasty.controller.ServiceInterface;
import com.tasty.notice.dao.NoticeDao;
import com.tasty.notice.dao.OracleNoticeDao;
import com.tasty.notice.model.Notice;

public class NoticeListService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		
		NoticeDao dao = new OracleNoticeDao();
		List<Notice> list=dao.list(obj);
		listGuideline();
		return list;
	}

	private void listGuideline() {
		// TODO Auto-generated method stub
		System.out.println("| 글번호 | 글제목 |  작성일 | 시작일 | 종료일 |");
		
	}

}
