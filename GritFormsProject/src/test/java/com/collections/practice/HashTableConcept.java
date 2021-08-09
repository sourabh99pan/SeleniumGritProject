package com.collections.practice;

import java.util.Hashtable;

public class HashTableConcept {

	public static void main(String[] args) {
		 Hashtable<String, Integer> marks = new Hashtable<String, Integer>();
		 
		 marks.put("Sourabh", 100);
		 marks.put("Tom", 101);
		 marks.put("Kai", 103);
		 marks.put("Natalee", 106);
		 marks.put("Peter", 104);
		 marks.put("Tony", 1067);
		 
		 System.out.println(marks.get("Sourabh"));

	}

}
