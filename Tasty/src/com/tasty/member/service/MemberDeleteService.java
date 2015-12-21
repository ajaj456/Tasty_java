package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.model.Login;
import com.tasty.member.model.Member;
import com.tasty.view.member.InputMember;

public class MemberDeleteService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		MemberDao dao = new MemberDao();
		
		InputMember in = new InputMember();
		
		Member member;
		
		if(Login.grade == 9) {
			member = in.inputUpdateMember();
			dao.update(member);
		}
		else {
			member = in.inputUpdateMember(Login.id);
			dao.update(member);
		}
		
		return null;
	}
}
