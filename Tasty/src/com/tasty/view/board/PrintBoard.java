package com.tasty.view.board;

import java.util.ArrayList;
import java.util.List;

import com.tasty.board.model.Board;



public class PrintBoard{
	public void Print(Object obj) {
		// TODO Auto-generated method stub
		// 작업해야함
		Board board = (Board)obj;
		System.out.println();
		System.out.println("글번호:"+board.getNo());
		System.out.println("제목:"+board.getTitle());
		System.out.println("내용:"+board.getContent());
		System.out.println("작성자:"+board.getWriter());
		System.out.println("작성일:"+board.getWdate());
		System.out.println("조회수:"+board.getHit());
		
	}
	public void printList(Object obj) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		ArrayList<Board> list = (ArrayList<Board>)obj;
		for (Board board : list) {
			System.out.println("|" + board.getNo() + " | " + board.getTitle() + " | " + board.getWdate() + " | "
					+ board.getHit() + "|");
		}

	}
}
