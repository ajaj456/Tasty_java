package com.tasty.qna.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.exception.QnaNotFoundException;
import com.tasty.member.model.Login;
import com.tasty.qna.dao.OracleQnaDao;
import com.tasty.qna.dao.QnaDao;
import com.tasty.qna.model.Qna;
import com.tasty.util.Input;
import com.tasty.util.Print;
import com.tasty.view.qna.PrintQna;

public class QnaViewService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		System.out.print("질문번호: ");
		QnaDao dao = new OracleQnaDao();
		Qna qna = dao.view(Input.inputInt());	// Input.inputInt()로 입력된 숫자를 dao.view()가 받아 해당되는
												// 글 번호의 Qna 타입 데이터를 불러와 qna에 대입
		try {
			checkQna(qna);
		} catch (QnaNotFoundException e) {
			e.getMessage();
			return null;
		}
		dao.increase(qna.getNo());	// 받아온 qna의 글번호를 dao.increse로 보내 해당 글의 조회수를 1 올림
		while(true) {
			PrintQna out = new PrintQna();
			out.printView(qna);	// qna의 내용을 화면에 표시
			ServiceInterface service = null;
			Print.printMenu("1. 질문수정\t2. 질문삭제\n3. 답변하기|수정\n0. 이전 메뉴");			
			switch(Input.inputInt()) {
			case 1:
				// 질문수정
				service = new QnaUpdateService();
				if (qna.getWriter().equals(Login.name))	// 로그인 계정의 이름과 작성자의 이름이 같으면 수정 가능
					service.service(qna);
				else
					System.out.println("작성자만 수정할 수 있습니다.");
				break;
			
			case 2:
				// 질문삭제
				service = new QnaDeleteService();
				if (qna.getWriter().equals(Login.name))	// 로그인 계정의 이름과 작성자의 이름이 같으면 삭제 가능
					service.service(qna.getNo());
				else
					System.out.println("작성자만 삭제할 수 있습니다.");
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

	private void checkQna(Qna qna) throws QnaNotFoundException {
		if(qna == null)
			throw new QnaNotFoundException();
	}

}
