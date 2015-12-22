package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.member.model.Member;
import com.tasty.view.member.InputMember;

// 회원정보수정 서비스
public class MemberUpdateService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		Member member = (Member) obj;
		MemberDao dao = new OracleMemberDao();
		InputMember in = new InputMember();
		
		in.inputUpdateMember(member); // 수정할 회원의 정보를 입력받기
		dao.update(member); // 입력받은 회원의 정보대로 수정
		return null;
	}
}
