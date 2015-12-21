package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.model.Member;
import com.tasty.util.Input;

public class MemberUpdatePwService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		Member member = (Member) obj;
		MemberDao dao = new MemberDao();
		String pw;
	
		pw = Input.inputString("비밀번호");
		dao.updatePw(member.getId(), pw);
		return null;
	}
}
