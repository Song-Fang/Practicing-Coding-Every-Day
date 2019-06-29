package com.algorimthms;

import java.util.ArrayList;
import java.util.HashMap;

public class ZeroSubSum {
	public static void main(String[] args) {
		int[] array = {0,1,-1};
		ZeroSumSolution zss = new ZeroSumSolution();
		System.out.println(zss.zeroSum(array));
	}
}

class ZeroSumSolution {
	public ArrayList<Integer> zeroSum(int[] array) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if(array==null||array.length==0) {
			return ans;
		}
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(0, -1);
		int sum = 0;
		for(int i = 0;i<array.length;i++) {
			sum = sum+array[i];
			if(map.containsKey(sum)) {
				ans.add(map.get(sum)+1);
				ans.add(i);
				return ans;
			}else {
				map.put(sum, i);
			}
		}
		return ans;
	}
}