package com.collections.practice;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class HashMapExample {
	//HashMap is a class implements Map Interface
	//extends AbstractMap
	//it contains only unique elements 
	//store the values in key and value pair
	//it may have one null key and multiple null values
	//it maintains no order
	//concurrent modifications exception---fail---fast condition
	// it is not synchronized means not one by one---not thread safe
	
	public static void main(String[] args) {
		
		HashMap<Integer, String> hm = new <Integer, String>HashMap();
		Scanner in = new Scanner(System.in);
		for(int i =0;i<5;i++)
		{
			hm.put(i, in.next());
		}

		for(Entry<Integer, String> m:hm.entrySet())
		{
			System.out.println("Key "+m.getKey()+" "+" Value "+m.getValue());
		}
	}

}
