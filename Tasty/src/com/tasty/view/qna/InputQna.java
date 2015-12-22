package com.tasty.view.qna;

import com.tasty.member.model.Login;
import com.tasty.qna.model.Qna;
import com.tasty.util.Input;

public class InputQna {

	public Qna inputData() {	// 비어있는 Qna 데이터에 데이터를 채워넣는 메소드
		Qna qna = new Qna();
		qna.setTitle(Input.inputString("질문제목"));
		qna.setQuestion(Input.inputString("질문내용"));
		if(Login.id != null)
			qna.setWriter(Login.name);	// 로그인이 되어있으면 작성자에 계정의 이름을 대입
		else
			qna.setWriter(Input.inputString("작성자"));
		return qna;
	}

	public void inputUpdateData(Qna qna) {	// Qna 데이터의 수정을 위한 메소드
		qna.setTitle(Input.inputString("질문제목"));
		qna.setQuestion(Input.inputString("질문내용"));
		if(Login.id != null)
			qna.setWriter(Login.name);	// 로그인이 되어있으면 작성자에 계정의 이름을 대입
		else
			qna.setWriter(Input.inputString("작성자"));
		return;
	}

	public void inputReplyData(Qna qna) {	// Qna 데이터에 Answer 항목을 채우기 위한 메소드
		qna.setAnswer(Input.inputString("답변내용"));
		return;
	}

	
}
