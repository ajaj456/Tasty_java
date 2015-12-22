/*
 * 글삭제를 위한 클래스 
 */
package com.tasty.notice.sevice;

import com.tasty.controller.ServiceInterface;
import com.tasty.notice.dao.NoticeDao;
import com.tasty.notice.dao.OracleNoticeDao;

public class NoticeDeleteService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		NoticeDao dao  = new OracleNoticeDao();// 객체 생성 및 호출
		dao.delete((int)obj); // 객체를 통한 메소드() 실현
		return null;
	}

}