package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.member.model.Member;
import com.tasty.view.member.InputMember;

public class MemberWriteService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		InputMember in = new InputMember();
		
		Member member = in.inputMember();
		
		MemberDao dao = new OracleMemberDao();
		
		dao.write(member);
		
		return member;
	}
}
