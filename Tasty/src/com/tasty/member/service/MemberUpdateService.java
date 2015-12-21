package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.model.Login;
import com.tasty.member.model.Member;
import com.tasty.util.Input;
import com.tasty.view.member.InputMember;

public class MemberUpdateService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		MemberDao dao = new MemberDao();
		
		InputMember in = new InputMember();
		
		Member member;
		String pw;
		String id;
		
		if(((String)obj).equals("all")) {
			if(Login.grade == 9)
				member = in.inputUpdateMember();
			else
				member = in.inputUpdateMember(Login.id);
			dao.update(member);
		}
		
		if(((String)obj).equals("pw")) {
			if(Login.grade == 9) {
				id = Input.inputString("아이디");
				pw = Input.inputString("비밀번호");
			}
			else {
				id = Login.id;
				pw = Input.inputString("비밀번호");
			}
			dao.updatePw(id, pw);
		}
		return null;
	}
}
