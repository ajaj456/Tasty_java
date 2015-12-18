package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.view.member.PrintMember;

public class MemberListService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		PrintMember out = new PrintMember();
		out.print(new MemberDao().list());
		return null;
	}
}
