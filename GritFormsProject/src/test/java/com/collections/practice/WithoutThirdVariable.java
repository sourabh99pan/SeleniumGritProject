package com.collections.practice;

public class WithoutThirdVariable {

	public static void main(String[] args) {

		String str1 = "Sourabh";
		String str2 = "Pandya";
		
		String str3 = str1+str2;
		
		 str1 = str3.replaceAll(str1, "");
		 
		 str2 = str3.replaceAll(str1, "");
		 
		 System.out.println(str1);
		 System.out.println(str2);
		
	}

}
