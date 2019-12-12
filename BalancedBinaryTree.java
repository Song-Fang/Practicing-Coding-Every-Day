package com.algorimthms;

public class BalancedBinaryTree {
	public static void main(String[] args) {
		Tree node1 = new Tree(1);
		Tree node2 = new Tree(2);
		Tree node3 = new Tree(3);
		node1.left = node2;
		node2.right = node3;
		BalancedBinaryTreeSolution bbts = new BalancedBinaryTreeSolution();
		System.out.println(bbts.isBalanced(node1));
	}
}

class BalancedBinaryTreeSolution {
	public boolean isBalanced(Tree root) {
		return isBalanced(root, null);
	}

	private boolean isBalanced(Tree root, int[] height) {
		if (root == null) {
			return true;
		}
		int[] left = new int[1];
		int[] right = new int[1];

		boolean result = isBalanced(root.left, left) && isBalanced(root.right, right);
		if (height != null) {
			height[0] = Math.max(left[0], right[0]) + 1;
		}
		return result && (Math.abs(left[0] - right[0]) <= 1);
	}
}
