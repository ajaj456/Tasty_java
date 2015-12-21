package com.tasty.notice.sevice;

import com.tasty.controller.ServiceInterface;
import com.tasty.notice.dao.NoticeDao;
import com.tasty.notice.model.Notice;
import com.tasty.notice.view.InputNotice;

public class NoticeUpdateService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		NoticeDao dao  = new NoticeDao();
		InputNotice in = new InputNotice();
		System.out.println("\n수정할 내용을 입력해 주세요!");
		Notice notice = new Notice();
		notice = in.inputWrite();
		dao.update(notice,(int)obj);
		return null;
	}

}
