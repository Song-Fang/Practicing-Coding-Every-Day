package com.algorimthms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateGraph {
	public static void main(String [] args) {
		int n = 5;
		String [] vertex = {"A","B","C","D","E"};
		CreateGraph graph = new CreateGraph(5);
		for(String node:vertex) {
			graph.insertVertex(node);
		}
		
		graph.insertEdges(0, 1, 1);
		graph.insertEdges(1, 2, 1);
		graph.insertEdges(0, 2, 1);
		graph.insertEdges(1, 3, 1);
		graph.insertEdges(1, 4, 1);
		
		graph.showGraph();
		
	}
	
	List<String> vertex;
	int [][] edges;
	int numOfEdges;
	
	public CreateGraph(int n) {
		edges = new int[n][n];
		vertex = new ArrayList<String>(n);
		numOfEdges = 0;
	}
	
	public void insertVertex(String vertex) {
		this.vertex.add(vertex);
	}
	
	public void insertEdges(int v1,int v2,int weight) {
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
	
	public int getVertexValue(int v1,int v2) {
		return edges[v1][v2];
	}
	
	public void showGraph() {
		for(int [] link:edges) {
			System.out.println(Arrays.toString(link));
		}
	}
}
