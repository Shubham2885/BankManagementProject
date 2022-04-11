package com.bz.comman;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	final static String CAP_LETTER_REGX = "^[A-Z].*";
	final static String MOBILE_NO_REGX = "^{1}[6-9]+[0-9]{9}";
	
	public static void checkStartWithCap(String input) {
		
		Pattern pattern = Pattern.compile(CAP_LETTER_REGX);
		Matcher matcher = pattern.matcher(input);
		
		if(!matcher.find()) {
			System.out.println("Please starting cap letter");
		}
	}
	
	public static void checkMobileNo(String input) {
		Pattern pattern = Pattern.compile(MOBILE_NO_REGX);
		Matcher matcher = pattern.matcher(input);
		
		if(!matcher.find()) {
			System.out.println("Please Enter valid mobile no");
		}
	}
}
