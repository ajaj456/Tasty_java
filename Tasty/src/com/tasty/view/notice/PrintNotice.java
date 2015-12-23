/*
 * 데이터를 출력하기 위한 클래스
 */
package com.tasty.view.notice;

import java.util.ArrayList;

import com.tasty.notice.model.Notice;

public class PrintNotice {
	public void Print(Object obj) {
		// TODO Auto-generated method stub
		// 글보기를 깔끔하게 보이기 위한 메소드
		Notice notice = (Notice) obj;
		System.out.println();
		System.out.println("글번호:" + notice.getNo());
		System.out.println("제목:" + notice.getTitle());
		System.out.println("내용:" + notice.getContent());
		System.out.println("작성일:" + notice.getWdate());
		System.out.println("시작날짜:" + notice.getStartDate());
		System.out.println("마감날짜:" + notice.getEndDate());
		

	}

	public void printList(Object obj) { // 글리스트를 깔끔하게 출력하기 위한 메소드 
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Notice> list = (ArrayList<Notice>) obj;
		for (Notice notice : list) {
			System.out.println("| " + notice.getNo() + " | " + notice.getTitle() + " | " + notice.getWdate() + " | "
					+ notice.getStartDate() + " | "+ notice.getEndDate() + " |");
		}

	}
}
