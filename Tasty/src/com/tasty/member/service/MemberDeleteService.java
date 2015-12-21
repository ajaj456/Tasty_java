package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.model.Member;
import com.tasty.util.Input;

public class MemberDeleteService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		MemberDao dao = new MemberDao();
		Member member = (Member) obj;
		String pw;
		int state = 0;
		
		pw = Input.inputString("비밀번호");
		
		if(pw.equals(dao.deleteCheck(member.getId())))
			state = dao.delete(member.getId());
		
		return state;
	}
}