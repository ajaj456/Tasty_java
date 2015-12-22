package com.tasty.exception;

public class NoticeNotFoundException extends Exception {
	public NoticeNotFoundException() {
		super("해당하는 게시물이 없습니다.");
	}
}
