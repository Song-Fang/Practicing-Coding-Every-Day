package com.algorimthms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofIslandsII {
	public static void main(String[] args) {
		NumberofIslandsIISolution nis = new NumberofIslandsIISolution();
		int [][] position = {{0,0},{0,1},{1,2},{2,1}};
		System.out.println(nis.numberOfIslands(3, 3, position));
	}
}

class NumberofIslandsIISolution {
	private int[] mRoot;
	private int count;

	public List<Integer> numberOfIslands(int m, int n, int[][] position) {
		mRoot = new int[m * n];
		Arrays.fill(mRoot, -1);
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < position.length; i++) {
			int z = position[i][1] + n * position[i][0];
			mRoot[z] = z;
			count++;

			int[] dx = { 1, -1, 0, 0 };
			int[] dy = { 0, 0, 1, -1 };

			for (int j = 0; j < dx.length; j++) {
				int x = position[i][0] + dx[j];
				int y = position[i][1] + dy[j];
				int z0 = y + x * n;
				if (x < 0 || x >=m || y < 0 || y >= n || mRoot[z0] == -1) {
					continue;
				}

				union(z, z0);
			}

			result.add(count);
		}
		return result;

	}

	private void union(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);
		if (a_root != b_root) {
			mRoot[a_root] = mRoot[b_root];
			count--;
		}
	}

	private int find(int x) {
		while (x != mRoot[x]) {
			x = mRoot[x];
		}
		return x;
	}
}
