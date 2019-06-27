package com.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Test4 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		list.add(6);
		list.add(8);
		list.add(10);
		list.add(14);
		list.add(17);
		list.add(10);
		System.out.println(list);
		deleteDuplicate5(list);
		System.out.println(list);

	}

//out of order	
	public static List<Integer> deleteDuplicate(List<Integer> list) {
		HashSet<Integer> set = new HashSet<Integer>(list);
		list.clear();
		list.addAll(set);
		return list;

	}

//double loop
	public static List<Integer> deleteDuplicate2(List<Integer> list) {
		for(int i =0;i<list.size()-1;i++) {
			for(int j = i+1;j<list.size();j++) {
				if(list.get(i).equals(list.get(j))) {
					list.remove(j);
				}
			}
		}
		return list;
	}
	
//use iterator
	public static List<Integer> deleteDuplicate3(List<Integer> list){
		List<Integer> newList = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			int element = iter.next();
			if(set.add(element)) {
				newList.add(element);
			}
		}
		list.clear();
		list.addAll(newList);
		return list;
	}
	
//use iterator2
//It is wrong, iterator will lose source
	public static List<Integer> deleteDuplicate4(List<Integer> list){
		HashSet<Integer> set = new HashSet<Integer>();
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			int element = iter.next();
			if(!set.add(element)) {
				list.remove((Integer)element);
			}
		}
		return list;
	}
	
//use contains and new List
	
	public static List<Integer> deleteDuplicate5(List<Integer> list){
		List<Integer> newList = new ArrayList<Integer>();
		for(int i =0;i<list.size();i++) {
			if(!newList.contains(list.get(i))) {
				//newList.add(list.get(i));
				list.remove(i);
			}
		}
		
		//list.clear();
		//list.addAll(newList);
		return list;
		
	}
	

}
