package com.algorimthms;

public class BiggestLengthofTree {
	public static void main(String[] args) {
		Tree node1 = new Tree(5);
		Tree node2 = new Tree(6);
		Tree node3 = new Tree(7);
		node1.left = node2;
		node1.right = node3;
		BiggestDepthOfTreeSolution bdos = new BiggestDepthOfTreeSolution();
		System.out.println(bdos.biggestDepthOfTree(node1));

	}

}

class BiggestDepthOfTreeSolution {
	public int biggestDepthOfTree(Tree node) {
		if (node == null) {
			return 0;
		}
		return Math.max(biggestDepthOfTree(node.left), biggestDepthOfTree(node.right)) + 1;

	}
}

class Tree {
	int val;
	Tree left;
	Tree right;

	public Tree(int val) {
		super();
		this.val = val;
	}

	public Tree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public Tree getLeft() {
		return left;
	}

	public void setLeft(Tree left) {
		this.left = left;
	}

	public Tree getRight() {
		return right;
	}

	public void setRight(Tree right) {
		this.right = right;
	}

}
