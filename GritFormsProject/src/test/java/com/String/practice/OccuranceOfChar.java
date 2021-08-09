package com.String.practice;

public class OccuranceOfChar {

	public static void main(String[] args) {

		String stt = "Selenium";
		int count = 0;
		int len = stt.length();
		
		for(int i = 0;i<len-1;i++)
		{
			if(stt.charAt(i)=='e')
			{
				count++;
			}
		}
		
		System.out.println(count);
	}

}
