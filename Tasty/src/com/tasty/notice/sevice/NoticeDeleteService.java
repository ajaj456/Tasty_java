package com.tasty.notice.sevice;

import com.tasty.controller.ServiceInterface;
import com.tasty.notice.dao.NoticeDao;

public class NoticeDeleteService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		NoticeDao dao  = new NoticeDao();
		dao.delete((int)obj);
		return null;
	}

}