package com.algorimthms;

public class IsSameTree {
	public static void main(String[] args) {
		Tree tree1 = new Tree(5);
		Tree tree2 = new Tree(6);
		Tree tree3 = new Tree(7);
		tree1.left = tree2;
		tree1.right = tree3;
		
		Tree tree4 = new Tree(5);
		Tree tree5 = new Tree(6);
		Tree tree6 = new Tree(7);
		tree4.left = tree5;
		tree4.right = tree6;
		IsSameTreeSolution ist = new IsSameTreeSolution();
		System.out.println(ist.isSameTree(tree1, tree4));
		
	}
}

class IsSameTreeSolution{
	public boolean isSameTree(Tree tree1, Tree tree2) {
		if(tree1==null&tree2==null) {
			return true;
		}
		if(tree1==null||tree2 ==null) {
			return false;
		}
		
		return tree1.val==tree2.val&&isSameTree(tree1.left,tree2.left)&&isSameTree(tree1.right,tree2.right);
	}
}
