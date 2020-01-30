package com.algorimthms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CreateGraph {
	public static void main(String[] args) {
		int n = 5;
		String[] vertex = { "A", "B", "C", "D", "E" };
		CreateGraph graph = new CreateGraph(5);
		for (String node : vertex) {
			graph.insertVertex(node);
		}

		graph.insertEdges(0, 1, 1);
		graph.insertEdges(1, 2, 1);
		graph.insertEdges(0, 2, 1);
		graph.insertEdges(1, 3, 1);
		graph.insertEdges(1, 4, 1);

		graph.showGraph();
		boolean[] visited = new boolean[5];
		//graph.dfs(visited, 0);
		//graph.dfs();
		graph.bfs(visited, 0);
		

	}

	List<String> vertex;
	int[][] edges;
	int numOfEdges;
	boolean[] visited;

	public CreateGraph(int n) {
		visited = new boolean[n];
		edges = new int[n][n];
		vertex = new ArrayList<String>(n);
		numOfEdges = 0;
	}

	public void insertVertex(String vertex) {
		this.vertex.add(vertex);
	}

	public void insertEdges(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}

	public int getNumOfVertex() {
		return vertex.size();
	}

	public int getNumOfEdges() {
		return numOfEdges;
	}

	public String getValueByIndex(int v) {
		return vertex.get(v);
	}

	public int getVertexValue(int v1, int v2) {
		return edges[v1][v2];
	}

	public void showGraph() {
		for (int[] link : edges) {
			System.out.println(Arrays.toString(link));
		}
	}

	public int getFirstNeighbor(int v) {
		for (int i = 0; i < vertex.size(); i++) {
			if (edges[v][i] == 1) {
				return i;
			}
		}
		return -1;
	}

	public int getNextNeighbor(int v1, int v2) {
		for (int i = v2 + 1; i < vertex.size(); i++) {
			if (edges[v1][i] == 1) {
				return i;
			}
		}
		return -1;
	}

	public void dfs(boolean[] visited, int i) {
		System.out.print(getValueByIndex(i) + "->");
		visited[i] = true;
		int w = getFirstNeighbor(i);
		while (w != -1) {
			if (!visited[w]) {
				dfs(visited, w);
			}
			w = getNextNeighbor(i, w);
		}
	}

	public void bfs(boolean[] visited, int i) {
		System.out.print(getValueByIndex(i) + "->");
		visited[i] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(i);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			int neighbor = getFirstNeighbor(node);
			while (neighbor != -1) {
				if (!visited[neighbor]) {
					System.out.print(getValueByIndex(neighbor)+"->");
					queue.offer(neighbor);
					visited[neighbor]=true;
				}
				neighbor = getNextNeighbor(node,neighbor);	
			}
		}

	}

	public void dfs() {
		for (int i = 0; i < vertex.size(); i++) {
			if (!visited[i]) {
				dfs(visited, i);
			}
		}
	}
}
