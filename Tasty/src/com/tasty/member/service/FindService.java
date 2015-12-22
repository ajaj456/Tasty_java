package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.util.Input;

// 아이디 찾기, 비밀번호찾기 서비스
public class FindService implements ServiceInterface{
	@Override
	public Object service(Object obj) {
		MemberDao dao = new OracleMemberDao();
		
		String id;
		String email;
		
		// 전달받은 인자가 id이면 아이디 찾기
		if(((String)obj).equals("id")) {
			email = Input.inputString("이메일"); // 이메일 입력받기
			String findId = dao.findId(email); // 입력받은 이메일에 대한 아이디를 리턴 받는다
			System.out.println("회원님의 아이디는 " + findId + "입니다."); // 화면에 아이디 출력
		}
		// 전달받은 인자가 pw이면 비밀번호 찾기
		else if(((String)obj).equals("pw")) { 
			id = Input.inputString("아이디"); // 아이디 입력받기
			email = Input.inputString("이메일"); // 이메일 입력받기
			String findPw = dao.findPw(id, email); // 입력받은 아이디와 이메일에 대한 비밀번호를 리턴 받는다
			System.out.println("회원님의 비밀번호는 " + findPw + "입니다."); // 화면에 비밀번호 출력
		}
		
		return null;
	}
}
