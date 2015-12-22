package com.tasty.qna.service;

import java.util.List;

import com.tasty.controller.ServiceInterface;
import com.tasty.exception.QnaListNotFoundException;
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
		try {
			checkQnaList(list);	// 글리스트가 존재하는지 확인, 없으면 오류
		} catch (QnaListNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}
		PrintQna out = new PrintQna();
		out.printList(list);	// list의 내용물들을 출력
		return null;
	}

	// QnaListNotFoundException의 조건을 '질문이 하나도 존재하지 않을 때'로 설정
	private void checkQnaList(List<Qna> list) throws QnaListNotFoundException {
		if(list == null)
			throw new QnaListNotFoundException();
	}

}
