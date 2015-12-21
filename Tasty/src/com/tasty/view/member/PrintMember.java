package com.tasty.view.member;

import java.util.ArrayList;

import com.tasty.member.model.Login;
import com.tasty.member.model.Member;

public class PrintMember {
	public void print(Object obj) {
		if(Login.grade == 9) {
			if(obj instanceof ArrayList) {
				ArrayList<Member> list = (ArrayList<Member>) obj;	
				
				for(Member member : list)
					System.out.println(
							member.getId() + " / " +
							member.getPw() + " / " +
							member.getName() + " / " +
							member.getBirth() + " / " +
							member.getTel() + " / " + 
							member.getEmail() + " / " + 
							member.getGrade());
			}
			
			if(obj instanceof Member) {
				Member member = (Member) obj;
				System.out.println(
							member.getId() + " / " +
							member.getPw() + " / " +
							member.getName() + " / " +
							member.getBirth() + " / " +
							member.getTel() + " / " + 
							member.getEmail() + " / " + 
							member.getGrade());
			}
		}
		else {
			if(obj instanceof ArrayList) {
				ArrayList<Member> list = (ArrayList<Member>) obj;	
				
				for(Member member : list)
					System.out.println(
							member.getId() + " / " +
							member.getPw() + " / " +
							member.getName() + " / " +
							member.getBirth() + " / " +
							member.getTel() + " / " + 
							member.getEmail());
			}
			
			if(obj instanceof Member) {
				Member member = (Member) obj;
				System.out.println(
							member.getId() + " / " +
							member.getPw() + " / " +
							member.getName() + " / " +
							member.getBirth() + " / " +
							member.getTel() + " / " + 
							member.getEmail());
				}
		}
	}
}
