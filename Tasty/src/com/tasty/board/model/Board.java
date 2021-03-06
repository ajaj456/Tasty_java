package com.tasty.board.model;

public class Board {
	private int no;
	private String title,content,writer,wdate;
	private int hit;
	
	
	public Board(int no, String title,String writer, String wdate, int hit) {
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.wdate = wdate;
		this.hit = hit;
	}
	
	public Board(int no,String title,String content,String writer,String wdate,int hit){
		this(no,title,writer,wdate,hit);
		this.content = content;
	}
	public Board(){}
	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", wdate="
				+ wdate + ", hit=" + hit + "]";
	}
	
	
	
	
}
