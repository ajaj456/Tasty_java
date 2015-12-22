package com.tasty.exception;

public class WrongNumInputException extends Exception {
	public WrongNumInputException() {
		super("숫자만 입력해주세요.");
	}
}
