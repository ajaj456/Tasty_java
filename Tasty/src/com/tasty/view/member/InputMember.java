package com.tasty.view.member;

import com.tasty.member.model.Member;
import com.tasty.util.Input;

public class InputMember {
	public Member inputMember() {
		String id = Input.inputString("아이디");
		String pw = Input.inputString("비밀번호");
		String name = Input.inputString("이름");
		String birth = Input.inputString("생일");
		String tel = Input.inputString("연락처");
		String email = Input.inputString("이메일");
		
		return new Member(id, pw, name, birth, tel, email);
	}
	
	public Member inputUpdateMember(Member member) {
		String name = Input.inputString("이름");
		String birth = Input.inputString("생일");
		String tel = Input.inputString("연락처");
		String email = Input.inputString("이메일");
		
		member.setName(name);
		member.setBirth(birth);
		member.setTel(tel);
		member.setEmail(email);
		
		return member;
	}
}
