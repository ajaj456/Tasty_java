package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.member.model.Member;
import com.tasty.view.member.InputMember;

// 회원가입 서비스
public class MemberWriteService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		InputMember in = new InputMember();
		
		Member member = in.inputMember(); // 가입하려고 하는 회원의 정보 입력받기
		
		MemberDao dao = new OracleMemberDao();
		
		dao.write(member); // 회원가입 실행
		
		return member; // 회원가입한 정보 리턴
	}
}
