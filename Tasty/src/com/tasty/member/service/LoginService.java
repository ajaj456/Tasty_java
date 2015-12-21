package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.model.Login;
import com.tasty.member.model.Member;
import com.tasty.util.Input;

public class LoginService implements ServiceInterface{
	@Override
	public Object service(Object obj) {
		MemberDao dao = new MemberDao();
		
		Login login;
		
		if(obj != null) {
			Member member = (Member) obj;
			login = dao.login(member.getId(), member.getPw());
		}
		else {
			String id = Input.inputString("아이디");
			String pw = Input.inputString("비밀번호");
			
			login = dao.login(id, pw);
		}
		
		Login.id = login.getId();
		Login.name = login.getName();
		Login.grade = login.getGrade();
		
		return null;
	}
}
