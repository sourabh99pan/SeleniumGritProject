package com.collections.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class CollectionTestCode {

	public static void main(String[] args) {

		HashMap<Integer,String> hmp = new <Integer,String>HashMap();
		
		hmp.put(1, "Sourabh");
		hmp.put(2, "Pandya");
		hmp.put(3, "David");
		hmp.put(4, "Martin");
		
		for(Map.Entry<Integer, String> e:hmp.entrySet())
		{
			System.out.println(e.getKey()+" "+e.getValue());
		}
		

	}
}