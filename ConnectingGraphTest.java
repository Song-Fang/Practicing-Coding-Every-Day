package com.algorimthms;

class ConnectingGraphTest {
	public static void main(String [] args) {
		ConnectingGraph cg = new ConnectingGraph(5);
		System.out.println(cg.query(1, 2));
		cg.connect(1, 2);
		System.out.println(cg.query(1, 3));
		cg.connect(2, 4);
		System.out.println(cg.query(1, 4));
		
	}
}

class ConnectingGraph {
	private int[] graph;

	public ConnectingGraph(int n) {
		graph = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			graph[i] = i;
		}
	}

	public void connect(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);
		if (a_root != b_root) {
			graph[a_root] = b_root;
		}
	}

	public boolean query(int a, int b) {
		int a_root = find(a);
		int b_root = find(b);
		return a_root == b_root;
	}

	private int find(int x) {
		if (graph[x] == x) {
			return x;
		}

		return graph[x] = find(graph[x]);
	}
}
