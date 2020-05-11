package com.algorimthms;

public class ConnectingGraphTestII {
	public static void main(String[] args) {
		ConnectingGraphII cg = new ConnectingGraphII(5);
		System.out.println(cg.query(1));
		cg.connect(1, 2);
		System.out.println(cg.query(1));
		cg.connect(2, 4);
		System.out.println(cg.query(1));
		cg.connect(1, 4);
		System.out.println(cg.query(1));
		
	}
}

class ConnectingGraphII {
	private int[] graph;
	private int[] size;

	public ConnectingGraphII(int n) {
		graph = new int[n + 1];
		size = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			graph[i] = i;
			size[i] = 1;
		}
	}

	public void connect(int a, int b) {
		int root_a = find(a);
		int root_b = find(b);
		if (root_a != root_b) {
			graph[root_a] = root_b;
			size[root_b] += size[root_a];
		}
	}

	public int find(int x) {
		if (graph[x] == x) {
			return x;
		}

		return graph[x] = find(graph[x]);
	}

	public int query(int x) {
		return size[find(x)];
	}
}
