package com.algorimthms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {
//Test
	public static void main(String[] args) {
		GraphSolution gs = new GraphSolution();
		int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
		int n1 = 5;
		Boolean result = gs.validTree(n1, edges1);
		System.out.println(result);
		int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
		int n2 = 5;
		System.out.println(gs.validTree(n2, edges2));

	}
}

//Is valid Tree
class GraphSolution {
	public boolean validTree(int n, int[][] edges) {
		if (n == 0) {
			return false;
		}

		if (edges.length != n - 1) {
			return false;
		}

		Map<Integer, Set<Integer>> graph = initializeGraph(n, edges);
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> hash = new HashSet<Integer>();
		queue.offer(0);
		hash.add(0);
		int visited = 0;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			visited++;
			for (Integer neighbor : graph.get(node)) {
				if (hash.contains(neighbor)) {
					continue;
				}

				queue.offer(neighbor);
				hash.add(neighbor);
			}
		}

		return visited == n;
	}

	
//Describe the Graph	
	private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < n; i++) {
			graph.put(i, new HashSet<Integer>());
		}
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		return graph;
	}

}
