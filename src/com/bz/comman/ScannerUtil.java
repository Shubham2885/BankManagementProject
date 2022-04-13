package com.bz.comman;

import java.util.Scanner;

public class ScannerUtil {

	private static Scanner scanner = new Scanner(System.in);
	
	public static String getString(String message) {
		System.out.println("Enter the "+message);
		return scanner.next();
	}
	
	public static int getInt(String message) {
		System.out.println("Enter the "+message);
		return scanner.nextInt();
	}
	
	public static long getLong(String message) {
		System.out.println("Enter the "+message);
		return scanner.nextLong();
	}
	
	public static double getDouble(String message) {
		System.out.println("Enter the "+message);
		return scanner.nextDouble();
	}
	
}
