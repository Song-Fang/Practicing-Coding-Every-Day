package com.practice;

public class ReviewReverseLinkedList {
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
		print(n1);
		
		Solution s = new Solution();
		print(s.reverseLinkedList(n1));
		
	}
	
	private static void print(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println("null");
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}

class Solution{
	ListNode reverseLinkedList(ListNode head) {
		ListNode prev = null;
		ListNode curt = head;
		while(curt!=null) {
			ListNode temp = curt.next;
			curt.next = prev;
			prev = curt;
			curt = temp;
		}
		
		return prev;
	}
}
