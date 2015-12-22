package com.tasty.exception;

public class MemberNotFoundException extends Exception {
	public MemberNotFoundException() {
		super("해당하는 정보가 없습니다.");
	}
}
