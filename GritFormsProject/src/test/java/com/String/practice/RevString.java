package com.String.practice;

public class RevString {

	public static void main(String[] args) {
		String s = "Selenium";
		String s2;
		int len = s.length();
		
		for(int i =len-1;i>=0;i--)
		{
	
			System.out.println(s.charAt(i));
		}

		StringBuffer sf = new StringBuffer(s);
		System.out.println(sf.reverse());
	}

}
