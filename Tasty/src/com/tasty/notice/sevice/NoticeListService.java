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
		
		NoticeDao dao = new OracleNoticeDao(); // 생성 및 호출
		List<Notice> list=dao.list(obj); // list()에서 생긴 결과값을 list에 저장
		listGuideline(); // 호출
		return list;
	}

	private void listGuideline() {
		// TODO Auto-generated method stub
		System.out.println("| 글번호 | 글제목 |  작성일 | 시작일 | 종료일 |");
		
	}

}
