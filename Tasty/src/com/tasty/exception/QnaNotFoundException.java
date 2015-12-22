package com.tasty.exception;

// 질문보기에서 질문이 없을때 사용할 익셉션
@SuppressWarnings("serial")
public class QnaNotFoundException extends Exception {
	public QnaNotFoundException() {
		super("해당하는 질문이 없습니다.");
	}
}
