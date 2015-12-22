package com.tasty.qna.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.qna.dao.QnaDao;

public class QnaDeleteService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		int no = (Integer)obj;	// Object로 받아온 글번호를 정수타입으로 변환
		QnaDao dao = new QnaDao();
		dao.delete(no);	// QnaDao 클래스의 delete 메소드로 글번호를 넘김 
		return null;
	}

}
