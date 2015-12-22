package com.tasty.util;

import java.util.Scanner;

import com.tasty.exception.WrongNumInputException;

public class Input {
	public static int inputInt() throws WrongNumInputException {
		Scanner in = new Scanner(System.in);
		try {
			return Integer.parseInt(in.nextLine());
		}
		catch(Exception e) {
		}
		return -1;
	}
	
	public static int inputInt(String str) {
		System.out.print(str + ": ");
		Scanner in = new Scanner(System.in);
		try {
			return Integer.parseInt(in.nextLine());
		}
		catch(Exception e) {
		}
		return -1;
	}
	
	public static String inputString(String str) {
		System.out.print(str + ": ");
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}
}
