package com.tasty.view.member;

import java.util.ArrayList;

import com.tasty.member.model.Member;

public class PrintMember {
	public void print(Object obj) {
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
	}
}
