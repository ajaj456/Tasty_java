package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.view.member.PrintMember;

// 회원정보목록 보기
public class MemberListService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		PrintMember out = new PrintMember(); // 회원정보를 출력하기 위한 객체 생성
		out.print(new OracleMemberDao().list()); // 회원정보를 불러오면서 출력
		return null;
	}
}
