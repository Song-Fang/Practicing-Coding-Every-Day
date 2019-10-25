package com.algorimthms;

import java.util.ArrayList;
import java.util.List;

public class TriangleDP {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		list1.add(2);
		list2.add(3);
		list2.add(4);
		list3.add(6);
		list3.add(5);
		list3.add(7);
		list4.add(4);
		list4.add(1);
		list4.add(8);
		list4.add(3);

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		TriangleDPSolution ts = new TriangleDPSolution();
		System.out.println(ts.minimumTotal(list));

	}
}

class TriangleDPSolution {

	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		int n = triangle.size();
		int[][] ele = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				ele[i][j] = triangle.get(i).get(j);
			}
		}

		
		int[][] f = new int[n][n];
		for(int j =0;j<n;j++) {
			f[n-1][j] = ele[n-1][j];
		}
		
		for(int i = n-2;i>=0;i--) {
			for(int j=0;j<=i;j++) {
				f[i][j] = Math.min(f[i+1][j], f[i+1][j+1])+ele[i][j];
			}
		}
		
		return f[0][0];
	}
}
