package com.tasty.qna.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.qna.dao.QnaDao;
import com.tasty.qna.model.Qna;
import com.tasty.qna.service.QnaDeleteService;
import com.tasty.qna.service.QnaReplyService;
import com.tasty.qna.service.QnaUpdateService;
import com.tasty.util.Input;
import com.tasty.util.Print;
import com.tasty.view.qna.PrintQna;

public class QnaViewService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		System.out.print("질문번호: ");
		QnaDao dao = new QnaDao();
		Qna qna = dao.view(Input.inputInt());
		dao.increase(qna.getNo());
		while(true) {
			PrintQna out = new PrintQna();
			out.printView(qna);
			ServiceInterface service = null;
			Print.printMenu("1. 질문수정\t2. 질문삭제\n3. 답변하기|수정\n0. 이전 메뉴");			
			switch(Input.inputInt()) {
			case 1:
				// 질문수정
				service = new QnaUpdateService();
				service.service(qna);
				break;
			
			case 2:
				// 질문삭제
				service = new QnaDeleteService();
				service.service(qna.getNo());
				return null;
				
			case 3:
				// 답변하기
				service = new QnaReplyService();
				service.service(qna);
				break;
				
			case 0:
				// 이전 메뉴
				return null;
			}
		}
	}

}
