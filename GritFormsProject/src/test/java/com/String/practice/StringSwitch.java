package com.String.practice;

import java.util.Scanner;

public class StringSwitch {

	public static void main(String[] args) {

		switchcase();

	}

	public static void switchcase()
	{
		
		System.out.println("Enter you input");
		Scanner in = new Scanner(System.in);
		String input = in.next();
		
		switch(input)
		{
		case "one":
			System.out.println("one case");
			break;
		case "two":
			System.out.println("two case");
			break;
		case "three":
			System.out.println("three case");
			break;
		default:
			System.out.println("No match");
		}
	}
}
