package com.algorimthms;

public class SymmetricTree {
	public static void main(String[] args) {
		
	}
}

class SymmetricTreeSolution {
	public boolean isSymmetric(Tree root) {
		if(root==null) {
			return true;
		}
		
		return isSymmetric(root.left, root.right);	
	}
	
	private boolean isSymmetric(Tree left, Tree right) {
		if(left==null&&right==null) {
			return true;
		}
		
		if(left==null||right==null) {
			return false;
		}
		
		return left.val==right.val&&isSymmetric(left.left, right.right)&&isSymmetric(left.right,right.left);
	}
}