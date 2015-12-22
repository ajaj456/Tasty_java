package com.tasty.exception;

@SuppressWarnings("serial")
public class QnaNotFoundException extends Exception {
	public QnaNotFoundException() {
		super("해당하는 질문이 없습니다.");
	}
}
