package com.tasty.member.model;

public class Login {
	public static String id;
	public static String pw;
	public static String name;
	public static int grade;

	public Login() {}
	
	public Login(String id, String name, int grade) {
		Login.id = id;
		Login.name = name;
		Login.grade = grade;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		Login.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		Login.pw = pw;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		Login.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		Login.grade = grade;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", pw=" + pw + ", name=" + name + ", grade=" + grade + "]";
	}

}