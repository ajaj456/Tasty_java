package com.tasty.qna.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.qna.dao.QnaDao;
import com.tasty.qna.model.Qna;
import com.tasty.view.qna.InputQna;

public class QnaWriteService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		InputQna in = new InputQna();
		Qna qna = in.inputData();
		QnaDao dao = new QnaDao();
		dao.write(qna);
		return null;
	}

}
