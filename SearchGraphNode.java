package com.algorimthms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SearchGraphNode {

}

class SearchGraphSolution{
	public UnDirectedGraphNode searchGraphNode(UnDirectedGraphNode node, Map<UnDirectedGraphNode,Integer> value,int target) {
		if(node==null) {
			return null;
		}
		
		Queue<UnDirectedGraphNode> queue =new LinkedList<>();
		HashSet<UnDirectedGraphNode> hash = new HashSet<>();
		queue.offer(node);
		hash.add(node);
		while(!queue.isEmpty()) {
			UnDirectedGraphNode newNode = queue.poll();
			if(value.get(newNode)==target) {
				return newNode;
			}
			for(UnDirectedGraphNode neighbor:newNode.neighbors) {
				if(!hash.contains(neighbor)) {
					queue.offer(neighbor);
					hash.add(neighbor);
				}
			}
		}
		
		return null;
		
		
	}
}



