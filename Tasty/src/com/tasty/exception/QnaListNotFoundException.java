package com.tasty.exception;

// 글리스트에서 질문이 하나도 없을 때 사용할 익셉션
@SuppressWarnings("serial")
public class QnaListNotFoundException extends Exception {
	public QnaListNotFoundException() {
		super("아직 질문이 없습니다.");
	}
}
