package com.String.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class DuplicateStrings {

	public static void main(String[] args) {
		
		ArrayList<String> tree = new <String>ArrayList();
		int count =0;
		tree.add("Sourabh");
		tree.add("David");
		tree.add("Tony");
		tree.add("NULL");
		tree.add("Tony");
		
		/*for(String arr:tree)
		{
			System.out.println(arr);
		}*/
		
		for(int i=0;i<tree.size();i++)
		{
			for(int j =0;j<tree.size();j++)
			{
				if(i==j)
				{
					continue;
				}
				else if(tree.get(i).equalsIgnoreCase(tree.get(j)))
				{
					count++;					
					if(count==1)
					{
						System.out.println("Repeat string: "+tree.get(i));
					}
				}
			}
		}
		
		
		System.out.println("After Iterator");
		Iterator it = tree.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}

	}


