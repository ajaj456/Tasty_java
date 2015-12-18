package com.tasty.notice.view;

import java.util.List;

import com.tasty.notice.model.Notice;

public class PrintView {

	public void print(Object obj) {
		// TODO Auto-generated method stub
		// 작업해야함
		Notice notice = (Notice)obj;
		System.out.println();
		System.out.println("글번호:"+notice.getNo());
		System.out.println("글제목:"+notice.getTitle());
		System.out.println("글내용:"+notice.getContent());
		System.out.println("작성일:"+notice.getWdate());
		System.out.println("시작일:"+notice.getStartDate());
		System.out.println("마감일:"+notice.getEndDate());
	}

	public void printList(Object obj) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Notice> list = (List<Notice>) obj;
		for (Notice notice : list) {
			System.out.println("|" + notice.getNo() + " | " + notice.getTitle() + " | " + notice.getWdate() + " | "
					+ notice.getStartDate() + " | " + notice.getEndDate() + "|");
		}

	}

}
