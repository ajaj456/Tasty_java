package com.tasty.view.board;


import com.tasty.board.model.Board;
import com.tasty.util.Input;


public class InputBoard {
	Board board = new Board();

	public Board inputWrite() {
		// TODO Auto-generated method stub
		board.setTitle(Input.inputString("글제목"));
		board.setContent(Input.inputString("글내용"));
		board.setWriter(Input.inputString("작성자"));
		
		return board;
	}
	public void inputUpdateData(Board board) {
		// TODO Auto-generated method stub
		
		// 데이터를 키보드로 입력받아 저장한다.
		board.setTitle(Input.inputString("제목:"));
		board.setContent(Input.inputString("내용:"));
		board.setWriter(Input.inputString("작성자:"));
		
		
	}
}
