package com.collections.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ARrayListpractic {

	public static void main(String[] args) {

ArrayList <Integer>arn = new <Integer>ArrayList();
Scanner in = new Scanner(System.in);

for(int i=0;i<5;i++)
{
	arn.add(in.nextInt());
}

System.out.println("before sorting");

for(int a:arn)
{
	System.out.println(a);
}

arn.add(5, 5);
Collections.sort(arn);

System.out.println("after sorting");

for(int a:arn)
{
	System.out.println(a);
}

	}

}
