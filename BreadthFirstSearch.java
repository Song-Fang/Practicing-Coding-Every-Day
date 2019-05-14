package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	public static void main(String [] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		
		t1.setLeftChild(t2);
		t1.setRightChild(t3);
		t3.setLeftChild(t4);
		t3.setRightChild(t5);
		
		MySolutionBFS bfs = new MySolutionBFS();
		System.out.println(bfs.levelOrderTraverse(t1));
		
		
	}

}


class TreeNode{
	private int val;
	TreeNode leftChild;
	TreeNode rightChild;
	
	public TreeNode(int val) {
		this.val=val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
	
	
}

class MySolutionBFS{
	public ArrayList<ArrayList<Integer>> levelOrderTraverse (TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root==null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			ArrayList<Integer> level= new ArrayList<Integer>();
			int levelSize = queue.size();
			for(int i=0;i<levelSize;i++) {
				TreeNode node = queue.poll();
				level.add(node.getVal());
				if(node.leftChild!=null) {
					queue.offer(node.leftChild);
				}
				if(node.rightChild!=null) {
					queue.offer(node.rightChild);
				}
			}
			result.add(level);
			
		}
		
		return result;
		
	}
}
