package com.tasty.view.qna;

import java.util.List;

import com.tasty.qna.model.Qna;

public class PrintQna {

	public void printList(Object obj) {
		List<Qna> list = (List<Qna>)obj;
		for(Qna qna : list)
			System.out.println(qna);
	}

	public void printView(Qna qna) {
		System.out.println("질문번호 : " + qna.getNo());
		System.out.println("질문제목 : " + qna.getTitle());
		System.out.println("질문내용 : " + qna.getQuestion());
		System.out.println("답변내용 : " + qna.getAnswer());
		System.out.println("작성자 : " + qna.getWriter());
		System.out.println("작성일 : " + qna.getWdate());
		System.out.println("조회수 : " + qna.getHit());
	}

}
