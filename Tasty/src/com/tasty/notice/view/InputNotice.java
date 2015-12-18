package com.tasty.notice.view;

import com.tasty.notice.model.Notice;
import com.tasty.util.Input;

public class InputNotice {
	Notice notice = new Notice();

	public Notice inputWrite() {
		// TODO Auto-generated method stub
		notice.setTitle(Input.inputString("글제목"));
		notice.setContent(Input.inputString("글내용"));
		notice.setStartDate(Input.inputString("시작날짜"));
		notice.setEndDate(Input.inputString("마감날짜"));
		return null;
	}

}
