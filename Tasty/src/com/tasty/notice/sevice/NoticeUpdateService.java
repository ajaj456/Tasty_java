/*
 * 글수정을 위한 클래스 
 */
package com.tasty.notice.sevice;

import com.tasty.controller.ServiceInterface;
import com.tasty.notice.dao.NoticeDao;
import com.tasty.notice.dao.OracleNoticeDao;
import com.tasty.notice.model.Notice;
import com.tasty.view.notice.InputNotice;

public class NoticeUpdateService implements ServiceInterface {

	@Override
	public Object service(Object obj) {
		// TODO Auto-generated method stub
		NoticeDao dao  = new OracleNoticeDao(); // 객체 생성 및 호출
		InputNotice in = new InputNotice(); // 객체 생성 및 호출
		System.out.println("\n수정할 내용을 입력해 주세요!");
		Notice notice = in.inputWrite(); //  수정된 글을 notice 변수에 저장
		dao.update(notice,(int)obj); // dao객체를 통해서 메소드 처리
		return null;
	}

}
