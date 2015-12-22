package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.member.model.Member;
import com.tasty.view.member.InputMember;

public class MemberUpdateService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		Member member = (Member) obj;
		MemberDao dao = new OracleMemberDao();
		InputMember in = new InputMember();
		
		member = in.inputUpdateMember(member);
		dao.update(member);
		return null;
	}
}
