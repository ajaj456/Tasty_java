package com.tasty.view.qna;

import java.util.List;

import com.tasty.qna.model.Qna;

public class PrintQna {

	public void printList(Object obj) {
		@SuppressWarnings("unchecked")
		List<Qna> list = (List<Qna>) obj;
		System.out.println("| 글번호 | 글제목 | 작성일 | 작성자 | 조회수 |");
		for (Qna qna : list) {
			System.out.print("| " + qna.getNo() + " | " + qna.getTitle());
			if (qna.getAnswer() != null)
				System.out.print("(답변)");
			System.out.print(" | " + qna.getWriter() + " | " + qna.getWdate() + " | " + qna.getHit() + " |" + "\n");
		}
	}

	public void printView(Qna qna) {
		System.out.println("\n질문번호: " + qna.getNo());
		System.out.println("질문제목: " + qna.getTitle());
		System.out.println("질문내용: " + qna.getQuestion());
		System.out.println("답변내용: " + qna.getAnswer());
		System.out.println("작성자: " + qna.getWriter());
		System.out.println("작성일: " + qna.getWdate());
		System.out.println("조회수: " + qna.getHit() + "\n");
	}

}
