package com.tasty.qna.service;

import java.util.List;

import com.tasty.controller.ServiceInterface;
import com.tasty.qna.dao.QnaDao;
import com.tasty.qna.model.Qna;
import com.tasty.view.qna.PrintQna;

public class QnaListService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		List<Qna> list = null;
		QnaDao dao = new QnaDao();
		list = dao.list();
		PrintQna out = new PrintQna();
		out.printList(list);
		return null;
	}

}
