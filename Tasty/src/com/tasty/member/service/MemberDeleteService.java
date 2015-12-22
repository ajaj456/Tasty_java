package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.member.model.Member;
import com.tasty.util.Input;

// 회원탈퇴 서비스
public class MemberDeleteService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		MemberDao dao = new OracleMemberDao();
		Member member = (Member) obj; // 전달받은 객체 Member 타입으로 캐스팅
		String pw; // 비밀번호를 입력받기 위한 변수 생성
		int state = 0; // 탈퇴가 정상적으로 진행됐을 때의 결과값을 받기 위한 변수 생성
		
		pw = Input.inputString("비밀번호"); // 비밀번호 입력받기
		
		if(pw.equals(dao.deleteCheck(member.getId()))) // 회원의 비밀번호와 입력한 비밀번호가 일치하는지 확인
			if(Input.inputString("탈퇴하시겠습니까?(y/n)").equals("y")) // 탈퇴여부를 재차 확인
				state = dao.delete(member.getId()); // 회원 탈퇴
		
		return state;
	}
}
