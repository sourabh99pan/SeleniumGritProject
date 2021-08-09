package com.String.practice;

public class Removechar {

	public static void main(String[] args) {

		String str = "Sourabh";
		
		String str2 = str.replaceAll("S", "");
		
		System.out.println(str2);
		
		String str3 = "Sourabh123@#$%^&**(()**^&(&%*";
		
		String str4 = str3.replaceAll("[a-zA-Z12]","");
		
		System.out.println(str4);
		
	}

}
