package com.tasty.view.qna;

import com.tasty.qna.model.Qna;
import com.tasty.util.Input;

public class InputQna {

	public Qna inputData() {
		Qna qna = new Qna();
		qna.setTitle(Input.inputString("질문제목"));
		qna.setQuestion(Input.inputString("질문제목"));
		qna.setWriter(Input.inputString("작성자"));
		return qna;
	}

	
}
