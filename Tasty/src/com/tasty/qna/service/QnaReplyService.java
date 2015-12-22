package com.tasty.qna.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.qna.dao.OracleQnaDao;
import com.tasty.qna.dao.QnaDao;
import com.tasty.qna.model.Qna;
import com.tasty.view.qna.InputQna;

public class QnaReplyService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		Qna qna = (Qna)obj;	// 질문보기에서 표시되고 있는 Qna의 정보를 Object로 받아온 것을 Qna로 형변환
		InputQna in = new InputQna();
		in.inputReplyData(qna);	// qna의 Answer 항목에 답변 내용을 입력
		QnaDao dao = new OracleQnaDao();
		dao.reply(qna);	// Answer 항목이 채워진 qna를 dao.reply()에서 DB로 보내 update 처리
		return null;
	}

}
