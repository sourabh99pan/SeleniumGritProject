package com.collections.practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class HashsetConcept1 {

	public static void main(String[] args) {


		HashSet <String>hs = new <String> HashSet();
		
		Scanner in = new Scanner(System.in);
		
		for(int i=0;i<5;i++)
		{
			hs.add(in.nextLine());
		}
		
		//LinkedHashSet <String>lh = new <String> LinkedHashSet(hs);
		//LinkedList <String>ll = new <String> LinkedList(hs);
		//Collections.sort(ll);
			
		Iterator it =hs.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		

	}

}
