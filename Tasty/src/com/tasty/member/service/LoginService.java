package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.exception.MemberNotFoundException;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.member.model.Login;
import com.tasty.member.model.Member;
import com.tasty.util.Input;

// 로그인 서비스
public class LoginService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		MemberDao dao = new OracleMemberDao();
		
		Login login;
		
		if(obj != null) { // 회원가입 후 자동으로 로그인 될 때 실행
			Member member = (Member) obj; // 가입한 회원의 객체 member를 전달받아 저장
			login = dao.login(member.getId(), member.getPw()); // 로그인 실행
		}
		else { // 회원가입이 아니고 일반적으로 로그인을 실행했을 때 실행
			String id = Input.inputString("아이디"); // 아이디 입력받기
			String pw = Input.inputString("비밀번호"); // 비밀번호 입력받기
			login = dao.login(id, pw); // 로그인 실행
		}
		
		// 로그인을 실행했을 때 해당하는 아이디 및 비밀번호가 없다면
		// null값이 넘어오기 때문에 이에 발생하는 오류를 막기 위하여 Null을 체크한다.
		// 에러가 발생하면 에러메세지를 출력하고 로그인 하지 않고 리턴
		try {
			checkNull(login);
		}
		catch (MemberNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}
		// 로그인이 정상적으로 된다면 로그인 정보를 저장한다
		Login.id = login.getId();
		Login.name = login.getName();
		Login.grade = login.getGrade();
		
		return null;
	}
	
	public void checkNull(Login login) throws MemberNotFoundException {
		if(login == null) // 로그인 한 정보가 넘어오지 않아 login이 null이면 Exception 발생
			throw new MemberNotFoundException();
	}
}
