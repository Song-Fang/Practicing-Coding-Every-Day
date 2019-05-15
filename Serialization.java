package com.leetcode;

import java.util.ArrayList;

public class Serialization {
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(20);
		TreeNode t4 = new TreeNode(15);
		TreeNode t5 = new TreeNode(7);
		t1.setLeftChild(t2);
		t1.setRightChild(t3);
		t3.setLeftChild(t4);
		t3.setRightChild(t5);
		
		SerialSolution s = new SerialSolution();
		
		System.out.println(s.serialization(t1));
	}
}

class SerialSolution{
	public String serialization(TreeNode root){
		
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		if(root ==null) {
			return "{}";
		}
		queue.add(root);
		
		for(int i =0;i<queue.size();i++) {
			TreeNode node = queue.get(i);
			if(node==null) {
				continue;
			}
			queue.add(node.leftChild);
			queue.add(node.rightChild);
		}
		
		while(queue.get(queue.size()-1)==null) {
			queue.remove(queue.size()-1);
		}
		
		System.out.println(queue.size());
		
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(queue.get(0).getVal());
		
		for(int i =1;i<queue.size();i++) {
			if(queue.get(i)==null) {
				sb.append(",#");
				continue;
			}
			sb.append(",");
			sb.append(queue.get(i).getVal());
		}
		
		sb.append("}");
		
		return sb.toString();
		
		
	}
}
