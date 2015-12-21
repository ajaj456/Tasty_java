package com.tasty.view.qna;

import com.tasty.member.model.Login;
import com.tasty.qna.model.Qna;
import com.tasty.util.Input;

public class InputQna {

	public Qna inputData() {
		Qna qna = new Qna();
		qna.setTitle(Input.inputString("질문제목"));
		qna.setQuestion(Input.inputString("질문내용"));
		if(Login.id != null)
			qna.setWriter(Login.name);
		else
			qna.setWriter(Input.inputString("작성자"));
		return qna;
	}

	public void inputUpdateData(Qna qna) {
		qna.setTitle(Input.inputString("질문제목"));
		qna.setQuestion(Input.inputString("질문내용"));
		return;
	}

	public void inputReplyData(Qna qna) {
		qna.setAnswer(Input.inputString("답변내용"));
		return;
	}

	
}
