package com.algorimthms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {

}

class CloneGraphSolution{
	public UnDirectedGraphNode cloneGraph(UnDirectedGraphNode node) {
		if(node ==null) {
			return null;
		}
		
		//Use BFS to traverse all the nodes
		ArrayList<UnDirectedGraphNode> nodes = getNodes(node);
		
		//Copy nodes by using hashMap
		HashMap<UnDirectedGraphNode, UnDirectedGraphNode> mapping = new HashMap<>();
		for(UnDirectedGraphNode n:nodes) {
			mapping.put(n, new UnDirectedGraphNode(n.label));
		}
		
		//Copy neighbors
		for(UnDirectedGraphNode n :nodes) {
			UnDirectedGraphNode newNode = mapping.get(n);
			for(UnDirectedGraphNode neighbor:n.neighbors) {
				UnDirectedGraphNode newNeighbor = mapping.get(neighbor);
				newNode.neighbors.add(newNeighbor);
			}
		}
		
		return mapping.get(node);
		
	}
	
	private ArrayList<UnDirectedGraphNode> getNodes(UnDirectedGraphNode node) {
		Queue<UnDirectedGraphNode> queue = new LinkedList<>();
		HashSet<UnDirectedGraphNode> set = new HashSet<>();
		queue.offer(node);
		set.add(node);
		while(!queue.isEmpty()) {
			UnDirectedGraphNode head = queue.poll();
			for(UnDirectedGraphNode neighbor:node.neighbors) {
				if(!set.contains(neighbor)) {
					queue.offer(neighbor);
					set.add(neighbor);
				}
			}
		}
		
		return new ArrayList<>(set);
	}
}

class UnDirectedGraphNode{
	int label;
	ArrayList<UnDirectedGraphNode> neighbors;
	public UnDirectedGraphNode(int label) {
		this.label = label;
		neighbors = new ArrayList<UnDirectedGraphNode>();
	}
}



