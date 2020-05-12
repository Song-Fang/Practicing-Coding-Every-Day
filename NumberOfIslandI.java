package com.algorimthms;

import java.util.Arrays;

public class NumberOfIslandI {
	public static void main(String[] args) {
		NumberOfIslandISolution nisi = new NumberOfIslandISolution();
		int [][] grid = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
		System.out.println(nisi.numIslands(grid));
		
	}
}

class NumberOfIslandISolution {
	private int[] mRoot;
	private int count;

	public int numIslands(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		mRoot = new int[m * n];

		Arrays.fill(mRoot, -1);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					int z = i * n + j;
					mRoot[z] = z;
					count++;

					int[] dx = { 1, -1, 0, 0 };
					int[] dy = { 0, 0, 1, -1 };
					for (int k = 0; k < dx.length; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						int z0 = x * n + y;
						if (x < 0 || y < 0 || x >= m || y >= n || mRoot[z0] == -1)
							continue;

						union(z, z0);
					}
				}
			}
		}
		return count;
	}

	private int find(int x) {
		if (x == mRoot[x]) {
			return x;
		}

		return mRoot[x] = find(mRoot[x]);
	}

	private void union(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);

		if (a_root != b_root) {
			mRoot[a_root] = mRoot[b_root];
			count--;
		}
	}
}
