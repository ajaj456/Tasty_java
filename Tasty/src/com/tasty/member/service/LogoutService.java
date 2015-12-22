package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.model.Login;

// 로그아웃 서비스
public class LogoutService implements ServiceInterface{
	@Override
	public Object service(Object obj) {
		// 로그아웃을 위해 Login 클래스에 저장되어 있는 데이터 모두 초기화
		Login.id = null;
		Login.name = null;
		Login.grade = 0;
		return null;
	}
}
