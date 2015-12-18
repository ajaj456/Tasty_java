package com.tasty.util;

public class Print {
	public static void printMenu(String str) {
		System.out.println(str);
		System.out.print("메뉴를 선택하세요: ");
	}
	
	public static void printTitle(String title, String ch) {
		System.out.println();
		int length = 40 - title.length();
		for(int i=0; i<length/2; i++)
			System.out.print(ch);
		System.out.print(title);
		for(int i=0; i<length/2; i++)
			System.out.print(ch);
		System.out.println();
	}
}
