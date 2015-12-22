package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.member.model.Member;
import com.tasty.util.Input;

public class MemberDeleteService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		MemberDao dao = new OracleMemberDao();
		Member member = (Member) obj;
		String pw;
		int state = 0;
		
		pw = Input.inputString("비밀번호");
		
		if(pw.equals(dao.deleteCheck(member.getId())))
			if(Input.inputString("탈퇴하시겠습니까?(y/n)").equals("y"))
				state = dao.delete(member.getId());
		
		return state;
	}
}
