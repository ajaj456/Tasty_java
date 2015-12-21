package com.tasty.member.model;

public class Member {
	String id;
	String pw;
	String name;
	String birth;
	String tel;
	String email;
	int grade;

	public Member() {
	}

	public Member(String id, String pw, String name, String birth, String tel, String email) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birth = birth;
		this.tel = tel;
		this.email = email;
	}

	public Member(String id, String pw, String name, String birth, String tel, String email, int grade) {
		this(id, pw, name, birth, tel, email);
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", birth=" + birth + ", tel=" + tel + ", email="
				+ email + ", grade=" + grade + ", getId()=" + getId() + ", getPw()=" + getPw() + ", getName()="
				+ getName() + ", getBirth()=" + getBirth() + ", getTel()=" + getTel() + ", getEmail()=" + getEmail()
				+ ", getGrade()=" + getGrade() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}