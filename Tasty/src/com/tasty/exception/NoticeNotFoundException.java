/*
 * 공지 게시판에서 없는 글번호를 불러오는 경우,
 * 그 오류를 잡아내는 익셉션
 */
package com.tasty.exception;

public class NoticeNotFoundException extends Exception {
	public NoticeNotFoundException() {
		super("해당하는 게시물이 없습니다.");
	}
}
