package com.String.practice;

import java.util.Arrays;
import java.util.Scanner;

public class StringTestCode {

	public static void main(String[] args) {

		//Converting string to character array  
		char str[] = "GreekforGeeks".toCharArray();
		int n = str.length;
		
		System.out.println(removeduplicatechar(str,n));
		
	

	}
	
	public static String removeduplicatechar(char str[],int n)
	
	{
		int index=0;
		int i=0;
		int j=0;
		for(i=0;i<n;i++)
		{
			for(j=0;j<i;j++)
			{
				if(str[i]==str[j])
				{
					break;
				}
			}
			
			if(i==j)
			{
				str[index++]=str[i];
			}
		}
		return String.valueOf(Arrays.copyOf(str, index));
	}
}
