package com.tasty.notice.sevice;

import com.tasty.controller.ServiceInterface;
import com.tasty.notice.dao.NoticeDao;
import com.tasty.notice.view.PrintView;

public class NoticeViewService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		NoticeDao dao = new NoticeDao();
		obj = dao.view();
		PrintView out = new PrintView();
		out.print(obj);
		return obj;
	}

}
