package com.tasty.qna.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.qna.dao.QnaDao;

public class QnaDeleteService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		int no = (Integer)obj;
		QnaDao dao = new QnaDao();
		dao.delete(no);
		return null;
	}

}
