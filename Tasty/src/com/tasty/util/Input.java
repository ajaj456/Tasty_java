package com.tasty.util;

import java.util.Scanner;

public class Input {
	public static int inputInt() {
		Scanner in = new Scanner(System.in);
		return Integer.parseInt(in.nextLine());
	}
	
	public static int inputInt(String str) {
		System.out.print(str + ": ");
		Scanner in = new Scanner(System.in);
		return Integer.parseInt(in.nextLine());
	}
	
	public static String inputString(String str) {
		System.out.print(str + ": ");
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
}
