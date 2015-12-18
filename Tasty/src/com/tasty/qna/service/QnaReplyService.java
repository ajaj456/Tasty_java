package com.tasty.qna.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.qna.dao.QnaDao;
import com.tasty.qna.model.Qna;
import com.tasty.view.qna.InputQna;

public class QnaReplyService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		Qna qna = (Qna)obj;
		InputQna in = new InputQna();
		in.inputReplyData(qna);
		QnaDao dao = new QnaDao();
		dao.reply(qna);
		return null;
	}

}
