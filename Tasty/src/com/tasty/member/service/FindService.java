package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.member.model.Member;
import com.tasty.util.Input;

public class FindService implements ServiceInterface{
	@Override
	public Object service(Object obj) {
		OracleMemberDao dao = new OracleMemberDao();
		Member member;
		
		String id;
		String email;
		
		if(((String)obj).equals("id")) {
			email = Input.inputString("이메일");
			String findId = dao.findId(email);
			System.out.println("회원님의 아이디는 " + findId + "입니다.");
		}
		else {
			id = Input.inputString("아이디");
			email = Input.inputString("이메일");
			String findPw = dao.findPw(id, email);
			System.out.println("회원님의 비밀번호는 " + findPw + "입니다.");
		}
		
		return null;
	}
}
