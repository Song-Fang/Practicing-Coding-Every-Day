package com.algorimthms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopologicalSorting {

}

class SortSolution{
	public ArrayList<DirectedGraphNode> topologicalSorting(ArrayList<DirectedGraphNode> graph){
		ArrayList<DirectedGraphNode> order = new ArrayList<>();
		if(graph ==null) {
			return order;
		}
		
		Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);
		
		Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
		
		//Start nodes
		for(DirectedGraphNode node:graph) {
			if(indegree.get(node)==0) {
				queue.offer(node);
				order.add(node);
			}
		}
		
		while(!queue.isEmpty()) {
			DirectedGraphNode node = queue.poll();
			for(DirectedGraphNode neighbor:node.neighbors) {
				indegree.put(neighbor, indegree.get(neighbor)-1);
				if(indegree.get(neighbor)==0) {
					queue.offer(neighbor);
					order.add(neighbor);
				}
			}
		}
		
		return order;
		
	}
	
	private Map<DirectedGraphNode,Integer> getIndegree(ArrayList<DirectedGraphNode> graph){
		Map<DirectedGraphNode,Integer> indegree = new HashMap<>();
		
		for(DirectedGraphNode node:graph) {
			indegree.put(node, 0);
		}
		
		for(DirectedGraphNode node:graph) {
			for(DirectedGraphNode neighbor:node.neighbors) {
				indegree.put(neighbor, indegree.get(neighbor)+1);
			}
		}
		
		return indegree;
		
	}
	
	
}


class DirectedGraphNode{
	int label;
	ArrayList<DirectedGraphNode> neighbors;
	public DirectedGraphNode(int label) {
		this.label=label;
		neighbors=new ArrayList<DirectedGraphNode>();
	}
}
