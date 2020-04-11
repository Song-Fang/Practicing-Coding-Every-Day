package com.algorimthms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumTreeWidth {

}

/*
 * BFS
 */
/*
class MaximumTreeWidthSolution{
	public int widthOfBinaryTree(TreeNode root) {
		if(root==null) return 0;
		Queue<AnnotateTree> queue = new LinkedList<>();
		int result = 0;
		int depth = 0;
		int left = 0;
		
		queue.offer(new AnnotateTree(root,0,0));
		while(!queue.isEmpty()) {			
			AnnotateTree node = queue.poll();
			if(node.node!=null) {
				queue.offer(new AnnotateTree(node.node.leftChild,node.depth+1,node.position*2));
				queue.offer(new AnnotateTree(node.node.rightChild,node.depth+1,node.position*2+1));
				if(depth!=node.depth) {
					depth = node.depth;
					left = node.position;
				}
				
				result = Math.max(result, node.position-left+1);
			}
		}
		return result;
		
	}
}

class AnnotateTree{
	TreeNode node;
	int depth;
	int position;
	
	public AnnotateTree(TreeNode node, int depth, int position) {
		this.node = node;
		this.depth = depth;
		this.position = position;
	}
}
*/

//DFS
class MaximumTreeWidthSolution{
	int result;
	HashMap<Integer,Integer> left;
	public int maximumTreeWidth(TreeNode root) {
		result = 0;
		left = new HashMap<>();
		helper(root,0,0);
		return result;
		
	}
	
	private void helper(TreeNode root, int depth, int position) {
		if(root==null) return;
		if(!left.containsKey(depth)) {
			left.put(depth, position);
		}
		result = Math.max(result, position-left.get(depth)+1);
		
	}
}


