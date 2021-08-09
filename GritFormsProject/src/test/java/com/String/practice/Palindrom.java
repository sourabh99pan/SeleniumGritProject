package com.String.practice;

public class Palindrom {

	static boolean value;
	public static void main(String[] args) {
		
		String str = "NITIN";
		
		if(isPalindromeString(str))
		{
			System.out.println("it is palindrom");
		}
		else
		{
			System.out.println("it is not a palindrom");
		}

	}
	
	
    public static boolean isPalindromeString(String str) {
        if (str == null)
            return false;
        int length = str.length();
       System.out.println(length);
        for (int i = 0; i < length / 2; i++) {

            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;
        }
        return true;
    }

}
