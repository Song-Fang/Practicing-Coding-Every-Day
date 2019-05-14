package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DeleteDuplicateElement {
	// Test
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(7);
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(1);
		list.add(2);
		list.add(10);
		list.add(12);
		list.add(15);
		list.add(10);
		System.out.println(list);
		MySolution ms = new MySolution();
		System.out.println(ms.deleteDuplicateElement(list));

	}
}

//Double Loop
/*class MySolution {
	public List<Integer> deleteDuplicateElement(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(j);
				}
			}
		}
		return list;
	}
}*/

//By using HashSet
/*class MySolution {
	public List<Integer> deleteDuplicateElement(List<Integer> list) {
		HashSet<Integer> hs = new HashSet<Integer>(list);
		list.clear();
		list.addAll(hs);
		return list;
	}
}*/

//Delete Duplicate Element in sequence
//Using Iterator
//Set is not in order

/*class MySolution {
	public List<Integer> deleteDuplicateElement(List<Integer> list) {
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> newList = new ArrayList<Integer>();

		for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
			int element = iter.next();
			if (set.add(element)) {
				newList.add(element);
			}
		}

		list.clear();
		list.addAll(newList);
		return list;

	}
}*/

//Using contains
//Using for loop

class MySolution {
	public List<Integer> deleteDuplicateElement(List<Integer> list) {
		List<Integer> newList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (!newList.contains(list.get(i))) {
				newList.add(list.get(i));
			}
		}

		list.clear();
		list.addAll(newList);
		return list;
	}
}
