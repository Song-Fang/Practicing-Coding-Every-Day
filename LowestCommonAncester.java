package com.algorimthms;

public class LowestCommonAncester {
	public static void main(String[] args) {
		Tree treeNode1 = new Tree(6);
		Tree treeNode2 = new Tree(2);
		Tree treeNode3 = new Tree(8);
		treeNode1.left = treeNode2;
		treeNode1.right = treeNode3;
		LCASolution lcas = new LCASolution();
		System.out.println(lcas.lcaSolution(treeNode1, treeNode2, treeNode3).val);
		
	}
}

class LCASolution {
	public Tree lcaSolution(Tree root, Tree p, Tree q) {
		if (!checkLCA(root, p) || !checkLCA(root, q)) {
			throw new IllegalArgumentException("no Ancester");
		}
		while (root != null) {
			if (p.val < root.val && q.val < root.val) {
				root = root.left;
			} else if (p.val > root.val && q.val > root.val) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}

	private boolean checkLCA(Tree root, Tree p) {
		Tree curtNode = root;
		while (curtNode != null) {
			if (p.val < curtNode.val) {
				curtNode = curtNode.left;
			} else if (p.val > curtNode.val) {
				curtNode = curtNode.right;
			} else {
				return true;
			}
		}
		return false;
	}
}