package com.tasty.util;

import java.util.Scanner;

public class Input {
	public int inputInt() {
		Scanner in = new Scanner(System.in);
		return Integer.parseInt(in.nextLine());
	}
	
	public String inputString(String str) {
		System.out.print(str + ": ");
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
}
