package com.tasty.qna.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.qna.dao.QnaDao;
import com.tasty.qna.model.Qna;
import com.tasty.view.qna.InputQna;

public class QnaWriteService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		InputQna in = new InputQna();
		Qna qna = in.inputData();	// qna에 새로운 내용을 채워넣음
		QnaDao dao = new QnaDao();
		dao.write(qna);	// dao.write()를 이용해 채워넣은 qna의 데이터를 DB에 insert
		return null;
	}

}
