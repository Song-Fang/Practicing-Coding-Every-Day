package com.algorimthms;

public class FastAndSlowPointer {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n2;
		JudgeCircle jc = new JudgeCircle();
		System.out.println(jc.judgeCircle(n1));
	}
}

class JudgeCircle{
	public boolean judgeCircle(ListNode head) {
		ListNode fast=head;
		ListNode slow = head;
		while(fast!=null) {
			if(fast.next!=null) {
				fast = fast.next.next;
			}else {
				return false;
			}
			slow = slow.next;
			if(slow ==fast) {
				return true;
			}
		}
		return false;
	}
}
