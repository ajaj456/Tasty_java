package com.tasty.qna.controller;

import com.tasty.controller.ControllerInterface;
import com.tasty.util.Input;
import com.tasty.util.Print;

public class QnaController implements ControllerInterface {
	@Override
	public void process() {
		while(true) {
			Print.printTitle("질문게시판", "*");
			Print.printMenu("1. 글리스트\t2. 글보기\n3. 글쓰기\n0. 이전 메뉴");
			
			switch(new Input().inputInt()) {
			case 1:
				// 글리스트
				break;
			
			case 2:
				// 글보기
				break;
				
			case 3:
				// 글쓰기
				break;
				
			case 0:
				// 이전 메뉴
				return;
			}
		}
	}
}
