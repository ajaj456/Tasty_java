package com.tasty.qna.model;

public class Qna {

	private int no;
	private String title, question, answer, writer, wdate;
	private int hit;
	public Qna(int no, String title, String question, String writer, String wdate, int hit) {
		this.no = no;
		this.title = title;
		this.question = question;
		this.writer = writer;
		this.wdate = wdate;
		this.hit = hit;
	}
	
	public Qna(){}

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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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
		return "Qna [no=" + no + ", title=" + title + ", question=" + question + ", answer=" + answer + ", writer="
				+ writer + ", wdate=" + wdate + ", hit=" + hit + "]";
	}
	
}
