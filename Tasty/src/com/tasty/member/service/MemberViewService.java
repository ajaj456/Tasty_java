package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.model.Member;
import com.tasty.util.Input;
import com.tasty.view.member.PrintMember;

public class MemberViewService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		MemberDao dao = new MemberDao();
		
		Member member;
		
		if(obj == null)
			member = dao.view(Input.inputString("아이디"));
		else
			member = dao.view((String)obj);
		
		PrintMember out = new PrintMember();
		
		out.print(member);
		
		return null;
	}
}
