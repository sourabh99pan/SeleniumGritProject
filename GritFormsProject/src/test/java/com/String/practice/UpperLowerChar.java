package com.String.practice;

import java.util.Scanner;

public class UpperLowerChar {

	public static void main(String[] args) {

		System.out.println("Enter a string");
		Scanner in = new Scanner(System.in);
		String str = in.next();
		
		int len= str.length();
		int upper=0;
		int lower=0;
		int num=0;
		int special=0;
		for(int i=0;i<len;i++)
		{
			char ch = str.charAt(i);
			
			if(ch>='A' && ch<='Z')
			{
				upper++;
			}
			else if(ch>='a' && ch<='z')
			{
				lower++;
			}
			else if(ch>='0' && ch<='9')
			{
				num++;
			}
			else
			{
				special++;
			}
		}

		
		System.out.println("lower: "+lower);
		System.out.println("Upper: "+upper);
		System.out.println("number: "+num);
		System.out.println("special: "+special);
	}

}
