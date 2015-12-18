package com.tasty.member.service;

import com.tasty.controller.ServiceInterface;
import com.tasty.member.model.Login;

public class LogoutService implements ServiceInterface{
	@Override
	public Object service(Object obj) {
		Login.id = null;
		Login.name = null;
		Login.grade = 0;
		
		System.out.println("로그아웃 되었습니다");
		
		return null;
	}
}
