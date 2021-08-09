package com.collections.practice;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListPractice {

	public static void main(String[] args) {
		
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		
		lhs.add(null);
		lhs.add("Sourabh");
		lhs.add("Millar");
		lhs.add("David");
		lhs.add("John");
		lhs.add("Steve");
		lhs.add(null);
		lhs.add("Sourabh");
		
		//it does allow only 1 null value and does not allow duplicate values, you can add but it will overwrite
		//it maintains inseration order
		for(String arr:lhs)
		{
			System.out.println(arr);
		}
		
		System.out.println("After Iterator");
		Iterator it = lhs.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

}
}
