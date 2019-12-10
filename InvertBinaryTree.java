package com.algorimthms;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

}


class InvertBinaryTreeSolution{
	public Tree invertBinaryTree(Tree root) {
		if(root==null) {
			return null;
		}
		
		Tree left = root.left;
		root.left = invertBinaryTree(root.right);
		root.right = invertBinaryTree(left);
		return root;
	}
	
	public Tree invertBinaryTree2(Tree root) {
		if(root==null) {
			return null;
		}
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Tree node = queue.poll();
			Tree left = node.left;
			node.left = node.right;
			node.right =left;
			if(node.left!=null) {
				queue.offer(node.left);
			}
			if(node.right!=null) {
				queue.offer(node.right);
			}
		}
		return root;
	}
}
