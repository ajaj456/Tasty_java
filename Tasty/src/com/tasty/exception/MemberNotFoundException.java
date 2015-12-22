package com.tasty.exception;

public class MemberNotFoundException extends Exception {
	public MemberNotFoundException() {
		super("해당하는 회원이 없습니다.");
	}
}
