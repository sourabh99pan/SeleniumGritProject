package com.collections.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayListPractice {

	public static void main(String[] args) {

		ArrayList<Integer> arr = new <Integer>ArrayList();
		Scanner in = new Scanner(System.in);
		
		for(int i=0;i<5;i++)
		{
			arr.add(in.nextInt());
		}
		
		System.out.println("Size of arraylist "+arr.size());
		
		System.out.println("Before sorting");
		for(int a:arr)
		{
			System.out.println(a);	
		}
		
		Collections.sort(arr);
		
		System.out.println("After sorting");
		for(int a:arr)
		{
			System.out.println(a);
		}
	}

}
