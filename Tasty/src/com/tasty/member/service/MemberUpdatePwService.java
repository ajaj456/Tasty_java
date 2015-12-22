package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.MemberDao;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.member.model.Member;
import com.tasty.util.Input;

// 회원정보수정 서비스
public class MemberUpdatePwService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		Member member = (Member) obj;
		MemberDao dao = new OracleMemberDao();
		String oldPw;
		String newPw;
		String newPw2;
		
		oldPw = Input.inputString("현재 비밀번호"); // 현재 계정의 비밀번호를 입력받는다
		newPw = Input.inputString("새로운 비밀번호"); // 새로운 비밀번호를 입력받는다
		newPw2 = Input.inputString("비밀번호 재확인"); // 새로 입력받은 비밀번호를 재차 입력받는다
		
		if(oldPw.equals(dao.updatePwCheck(member.getId()))) { // 현재 계정의 비밀번호와 입력받은 비밀번호의 일치여부를 확인
			if(newPw.equals(newPw2)) // 새로 입력받은 비밀번호가 일치하는지 확인
				dao.updatePw(member.getId(), newPw); // 비밀번호 변경
			else
				System.out.println("새로운 비밀번호가 일치하지 않습니다.");
		}
		else
			System.out.println("현재 비밀번호가 일치하지 않습니다.");
		
		return null;
	}
}
