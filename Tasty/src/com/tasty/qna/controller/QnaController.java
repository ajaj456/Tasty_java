package com.tasty.qna.controller;

import com.tasty.controller.ControllerInterface;
import com.tasty.controller.ServiceInterface;
import com.tasty.qna.service.QnaListService;
import com.tasty.qna.service.QnaViewService;
import com.tasty.qna.service.QnaWriteService;
import com.tasty.util.Input;
import com.tasty.util.Print;

public class QnaController implements ControllerInterface {
	@Override
	public void process() {
		while(true) {
			ServiceInterface service = null;
			Print.printTitle("질문게시판", "*");
			Print.printMenu("1. 글리스트\t2. 질문보기\n3. 질문하기\n0. 이전 메뉴");
			
			switch(Input.inputInt()) {
			case 1:
				// 글리스트 - 호출, 생성
				service = new QnaListService();
				service.service(null);
				break;
			
			case 2:
				// 질문보기 - 호출, 생성
				service = new QnaViewService();
				service.service(null);
				break;
				
			case 3:
				// 질문하기 -호출, 생성
				service = new QnaWriteService();
				service.service(null);
				break;
				
			case 0:
				// 이전 메뉴
				return;
			}
		}
	}
}
