package com.tasty.notice.sevice;

import com.tasty.controller.ServiceInterface;
import com.tasty.notice.dao.NoticeDao;
import com.tasty.notice.dao.OracleNoticeDao;
import com.tasty.notice.model.Notice;
import com.tasty.view.notice.InputNotice;

public class NoticeWriteService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		NoticeDao dao = new OracleNoticeDao(); 
		InputNotice in = new InputNotice();
		System.out.println("\n새로 작성할 글을 입력해주세요.");
		Notice notice = in.inputWrite();
		dao.write(notice);
		return null;
	}

}
