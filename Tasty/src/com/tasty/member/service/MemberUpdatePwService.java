package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.dao.OracleMemberDao;
import com.tasty.member.model.Member;
import com.tasty.util.Input;

public class MemberUpdatePwService implements ServiceInterface {
	@Override
	public Object service(Object obj) {
		Member member = (Member) obj;
		OracleMemberDao dao = new OracleMemberDao();
		String oldPw;
		String newPw;
		String newPw2;
		
		oldPw = Input.inputString("현재 비밀번호");
		newPw = Input.inputString("새로운 비밀번호");
		newPw2 = Input.inputString("비밀번호 재확인");
		
		if(oldPw.equals(dao.updatePwCheck(member.getId()))) {
			if(newPw.equals(newPw2))
				dao.updatePw(member.getId(), newPw);
			else
				System.out.println("새로운 비밀번호가 맞지 않습니다.");
		}
		else
			System.out.println("현재 비밀번호가 맞지 않습니다.");
		
		return null;
	}
}
