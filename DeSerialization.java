package com.leetcode;

import java.util.ArrayList;

public class DeSerialization {
	public static void main(String[] args) {
		String string = "{3,9,20,#,#,15,7}";
		DeSeriaSolution dss = new DeSeriaSolution();
		TreeNode root = dss.deSerialize(string);
		System.out.println(root);
	}
}

class DeSeriaSolution {
	public TreeNode deSerialize(String string) {
		if(string.equals("{}")) {
			return null;
		}
		String [] val = string.substring(1, string.length()-1).split(",");
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		int index = 0;
		boolean isLeftChild = true;
		TreeNode root = new TreeNode(Integer.parseInt(val[0]));
		queue.add(root);
		for(int i = 1;i<val.length;i++) {
			if(!val[i].equals("#")) {
				TreeNode node = new TreeNode(Integer.parseInt(val[i]));
				if(isLeftChild) {
					queue.get(index).leftChild=node;
				}else {
					queue.get(index).rightChild=node;
				}
				queue.add(node);
			}
			if(!isLeftChild) {
				index++;
			}
			isLeftChild=!isLeftChild;
		}
		
		return root;
	
	}
}
