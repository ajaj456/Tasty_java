package com.tasty.view.member;

import java.util.ArrayList;

import com.tasty.member.model.Login;
import com.tasty.member.model.Member;

public class PrintMember {
	public void print(Object obj) {
		if(Login.grade == 9) {
			if(obj instanceof ArrayList) {
				ArrayList<Member> list = (ArrayList<Member>) obj;
				
				String[] id = new String[list.size()];
				String[] pw = new String[list.size()];
				String[] name = new String[list.size()];
				String[] birth = new String[list.size()];
				String[] tel = new String[list.size()];
				String[] email = new String[list.size()];
				
				int maxId = 6;
				int maxPw = 8;
				int maxName = 4;
				int maxBirth = 8;
				int maxTel = 6;
				int maxEmail = 6;
				
				int i=0;
				for(Member member : list) {
					id[i] = member.getId();
					pw[i] = member.getPw();
					name[i] = member.getName();
					birth[i] = member.getBirth();
					tel[i] = member.getTel();
					email[i] = member.getEmail();
					i++;
				}
				
				for(i=0; i<list.size(); i++) {
					if(maxId < id[i].length())
						maxId = id[i].length();
					if(maxPw < pw[i].length())
						maxPw = pw[i].length();
					if(maxName < name[i].length())
						maxName = name[i].length();
					if(maxBirth < birth[i].length())
						maxBirth = birth[i].length();
					if(maxTel < tel[i].length())
						maxTel = tel[i].length();
					if(maxEmail < email[i].length())
						maxEmail = email[i].length();
				}
				
				System.out.print("| ");
				System.out.printf("%" + (maxId-3) + "s", "아이디");
				System.out.print(" | ");
				System.out.printf("%" + (maxPw-4) + "s", "비밀번호");
				System.out.print(" | ");
				System.out.printf("%" + (maxName-2) + "s", "이름");
				System.out.print(" | ");
				System.out.printf("%" + (maxBirth-4) + "s", "생년월일");
				System.out.print(" | ");
				System.out.printf("%" + (maxTel-3) + "s", "연락처");
				System.out.print(" | ");
				System.out.printf("%" + (maxEmail-3) + "s", "이메일");
				System.out.print(" |");
				System.out.println();
				
				for(Member member : list) {
					System.out.print("| ");
					System.out.printf("%" + maxId + "s", member.getId());
					System.out.print(" | ");
					System.out.printf("%" + maxPw + "s", member.getPw());
					System.out.print(" | ");
					System.out.printf("%" + maxName + "s", member.getName());
					System.out.print(" | ");
					System.out.printf("%" + maxBirth + "s", member.getBirth());
					System.out.print(" | ");
					System.out.printf("%" + maxTel + "s", member.getTel());
					System.out.print(" | ");
					System.out.printf("%" + maxEmail + "s", member.getEmail());
					System.out.print(" |");
					System.out.println();
					
					
//					System.out.println(
//							member.getId() + " / " +
//							member.getPw() + " / " +
//							member.getName() + " / " +
//							member.getBirth() + " / " +
//							member.getTel() + " / " + 
//							member.getEmail() + " / " + 
//							member.getGrade());
				}
			}
			
			if(obj instanceof Member) {
				System.out.println("| 아이디 | 비밀번호 | 이름 | 생년월일 | 연락처 | 이메일 |");
				Member member = (Member) obj;
				System.out.println("| " +
							member.getId() + " | " +
							member.getPw() + " | " +
							member.getName() + " | " +
							member.getBirth() + " | " +
							member.getTel() + " | " + 
							member.getEmail() + " | " + 
							member.getGrade() + " |");
			}
		}
		else {
			if(obj instanceof Member) {
				System.out.println("| 아이디 | 비밀번호 | 이름 | 생년월일 | 연락처 | 이메일 |");
				Member member = (Member) obj;
				System.out.println("| " +
							member.getId() + " | " +
							member.getPw() + " | " +
							member.getName() + " | " +
							member.getBirth() + " | " +
							member.getTel() + " | " + 
							member.getEmail() + " |");
				}
		}
	}
}
