package com.algorimthms;

public class DeepCopyLinkedList {
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
		
		DeepCopySolution s = new DeepCopySolution();
		print(s.deepCopyLinkedList(n1));
	}
	
	private static void print(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"->");
			head = head.next;
		}
		
		System.out.println("null");
	}
}

class DeepCopySolution{
	public ListNode deepCopyLinkedList(ListNode head) {
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode newNode, newHead;
		newHead = dummyNode;//manipulate dummyNode to make it point to the new LinkedList
		while(head!=null) {
			newNode = new ListNode(head.val);
			newHead.next = newNode;
			head = head.next;
			newHead = newNode;
		}
		return dummyNode.next;
	}
}
