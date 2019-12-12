package com.algorimthms;

import java.util.Stack;

public class BSTIterator {
	public static void main(String[] args) {
		Tree t1 = new Tree(8);
		Tree t2 = new Tree(6);
		Tree t3 = new Tree(12);
		t1.left = t2;
		t2.right = t3;
		BSTIteratorSolution bst = new BSTIteratorSolution(t1);
		System.out.println(bst.next());
		System.out.println(bst.next());
		System.out.println(bst.next());
		System.out.println(bst.next());
		
	}
}

class BSTIteratorSolution {
	Stack<Tree> stack;
	Tree curtNode;

	public BSTIteratorSolution(Tree node) {
		this.stack = new Stack<Tree>();
		this.curtNode = node;
	}

	public boolean hasNext() {
		return curtNode != null || !stack.isEmpty();
	}

	public int next() {
		int result = -1;
		while (hasNext()) {
			if (curtNode != null) {
				stack.push(curtNode);
				curtNode = curtNode.left;
			} else {
				curtNode = stack.pop();
				result = curtNode.val;
				curtNode = curtNode.right;
				break;
			}
		}
		return result;
	}

}
