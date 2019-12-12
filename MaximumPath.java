package com.algorimthms;

public class MaximumPath {
	public static void main(String[] args) {
		Tree node1 = new Tree(1);
		Tree node2 = new Tree(2);
		Tree node3 = new Tree(3);
		node1.left = node2;
		node1.right = node3;
		MaximumPathSolution mps = new MaximumPathSolution();
		System.out.println(mps.maxPath(node1));
	}
}

class MaximumPathSolution {
	public int maxPath(Tree root) {
		return maxPath(root, null);
	}

	private int maxPath(Tree root, int[] max) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int[] left = new int[1];
		int[] right = new int[1];
		int maxLeft = maxPath(root.left, left);
		int maxRight = maxPath(root.right, right);
		if (max != null) {
			max[0] = max(left[0], right[0], 0) + root.val;
		}

		return max(maxLeft, maxRight, left[0] + right[0] + root.val, root.val, left[0] + root.val, right[0] + root.val);
	}

	private int max(int... vals) {
		int max = Integer.MIN_VALUE;
		for (int val : vals) {
			max = Math.max(val, max);
		}
		return max;
	}
}
