package com.collections.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronizedArrayList {

	public static void main(String[] args) {
		
		//1. Collections.synchronizedList
		List<String> namelist = Collections.synchronizedList(new ArrayList<String>());
		namelist.add("Java");
		namelist.add("Python");
		namelist.add("Ruby");
		
		//add, remove- we dont need explicitly synchronization
		
		//to fetch value from this list we have to use explicit synchroniztion
		
		synchronized (namelist)
		{
			Iterator<String> it = namelist.iterator();
			 while(it.hasNext())
			 {
				 System.out.println(it.next());
			 }
		}

		//2.copyOnWriteArrayList -- it is a class: Thread safe/Synchronized already
		
		CopyOnWriteArrayList<String> emplist = new CopyOnWriteArrayList<String>();
		emplist.add("Tom");
		emplist.add("Steve");
		emplist.add("John");
		
		//here we dont need any explicitly synchronization
		Iterator<String> itr = emplist.iterator();
		 while(itr.hasNext())
		 {
			 System.out.println(itr.next());
		 } 
		
	}

}
