package com.tasty.qna.service;

import java.util.List;

import com.tasty.controller.ServiceInterface;
import com.tasty.qna.dao.OracleQnaDao;
import com.tasty.qna.dao.QnaDao;
import com.tasty.qna.model.Qna;
import com.tasty.view.qna.PrintQna;

public class QnaListService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		List<Qna> list = null;	// Qna 리스트를 받기 위한 List<Qna>객체 선언
		QnaDao dao = new OracleQnaDao();
		list = dao.list();	// dao.list()로 모든 Qna 리스트를 받아 list에 대입
		PrintQna out = new PrintQna();
		out.printList(list);	// list의 내용물들을 출력
		return null;
	}

}
