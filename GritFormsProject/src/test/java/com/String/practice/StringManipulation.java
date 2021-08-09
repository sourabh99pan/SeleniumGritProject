package com.String.practice;

public class StringManipulation {

	public static void main(String[] args) {

		String str = "I have BNSF Project In Capgeminia";
		
		int in = str.indexOf('a');
		
		System.out.println(in);//this will give 1st occrance
		
		System.out.println(str.indexOf('a', in+1));// this will give second occurance 
		
		System.out.println(str.indexOf("BNSF"));
		
		System.out.println(str.indexOf('B'));
		
		System.out.println(str.indexOf("hello"));//-1 means string will not be avaialble
		
		System.out.println(str.substring(0, 11));//it will return substring from a long string
		
		System.out.println(str.trim());//can trim before and after space
		
		System.out.println(str.replace("BNSF", "BSSD"));//replace old given string to new given string
		
		//split
		
		String test = "Hello_World_Test_Selenium";
		
		String testarr[] = test.split("_");
		
		for(String name: testarr)
		{
			System.out.println(name);
		}
		
		String s2 = "why";
		System.out.println(s2.concat(" so serious"));
		
		String x = "Hello";
		String y = "World";
		
		int a = 100;
		int b = 200;
		
		System.out.println(x+y+a+b);//see output carefully
		
		
		
	}

}
