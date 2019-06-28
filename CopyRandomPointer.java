package com.algorimthms;

import java.util.HashMap;

public class CopyRandomPointer {

}

class CopyRandomSolution{
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode dummy = new RandomListNode(0);
		dummy.next = head;
		RandomListNode newNode, prev;
		prev=dummy;
		HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		while(head!=null) {
			if(map.containsKey(head)) {
				newNode = map.get(head);
			}
			else {
				newNode = new RandomListNode(head.val);
			}
			prev.next = newNode;
			
			if(head.random!=null) {
				if(map.containsKey(head.random)) {
					newNode.random = map.get(head.random);
				}
				else {
					newNode.random = new RandomListNode(head.random.val);
				}
			}
			
			head = head.next;
			prev = newNode;
		}
		
		return dummy.next;
	}
}


class RandomListNode{
	int val;
	RandomListNode next, random;
	RandomListNode(int val){
		this.val = val;
	}
}

