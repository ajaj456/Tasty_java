package com.tasty.exception;

public class QnaNotFoundException extends Exception {
	public QnaNotFoundException() {
		super("해당하는 정보가 없습니다.");
	}
}
