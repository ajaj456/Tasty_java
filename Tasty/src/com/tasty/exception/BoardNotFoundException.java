package com.tasty.exception;

public class BoardNotFoundException extends Exception {
	public BoardNotFoundException() {
		super("해당하는 게시물이 없습니다.");
	}
}
