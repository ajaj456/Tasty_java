package com.tasty.exception;

public class QnaNotFoundException extends Exception {
	public QnaNotFoundException() {
		super("해당하는 질문이 없습니다.");
	}
}
