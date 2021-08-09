package com.collections.practice;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicateusingSet {

	public static void main(String[] args) {
		ArrayList <Integer>arn = new <Integer>ArrayList();
		Scanner in = new Scanner(System.in);

		for(int i=0;i<5;i++)
		{
			arn.add(in.nextInt());
		}
		
		System.out.println("list of numbers "+arn);
		
		// Now let's remove duplicate element without affecting order 
		// LinkedHashSet will guaranteed the order and since it's set 
		// it will not allow us to insert duplicates. 
		// repeated elements will automatically filtered.

			
		Set <Integer> numWithoutDuplicate = new LinkedHashSet<Integer> (arn);
		
		arn.clear();
		
		arn.addAll(numWithoutDuplicate);
		
		System.out.println("Array without duplicates using LinkedHashSet "+numWithoutDuplicate);
		

	}

}
