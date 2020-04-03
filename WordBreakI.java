package com.algorimthms;

import java.util.HashSet;

public class WordBreakI {
	public static void main(String[] args) {
		//String s = "applepenapple";
		//String [] nums = {"apple", "pen"};
		
		String s = "catsandog";
		String [] nums = {"cats", "dog", "sand", "and", "cat"};
		System.out.println(wordBreak(s,nums));
	}
	
	public static boolean wordBreak(String s, String [] nums) {
		if(s==null||s.length()==0||nums==null||nums.length==0) {
			return false;
		}
		
		//initialize a set, specify the capacity or parse a list
		HashSet<String> set = new HashSet<String>();
		for(String str:nums) {
			set.add(str);
		}
		
		boolean [] isWord = new boolean[s.length()+1];
		isWord[0] = true;
		for(int i =1;i<isWord.length;i++) {
			for(int j =i;j>0;j--) {
				String sub = s.substring(i-j,i);
				if(set.contains(sub)) {
					if(isWord[i-j]) {
						isWord[i] = true;
					}
				}
			}
		}
		
		return isWord[s.length()];
	}
}
