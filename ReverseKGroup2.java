package com.algorimthms;

public class ReverseKGroup2 {
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
		KGroupSolution2 s = new KGroupSolution2();
		print(s.kGroup(n1, 6));
		
		
		
	}
	
	private static void print(ListNode head) {
		while(head!=null) {
			System.out.print(head.val+"->");
			head = head.next;
		}
		System.out.println("null");
	}
}

class KGroupSolution2 {
	public ListNode kGroup(ListNode head,int k) {
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		head = dummyNode;
		while(head.next!=null) {
			head = reverseNextK(head,k);
		}
		return dummyNode.next;
	}
	
	private ListNode reverseNextK(ListNode head,int k) {
		ListNode n1 = head.next;
		ListNode nk = head;
		for(int i = 0;i<k;i++) {
			nk = nk.next;
			if(nk ==null) {
				break;
			}
		}
		
		ListNode nkplus;
		
		if(nk ==null) {
			nkplus = nk;
		}else {
			nkplus = nk.next;
		}
		
		ListNode prev = null;
		ListNode curt = n1;
		
		while(curt!=nkplus) {
			ListNode temp = curt.next;
			curt.next = prev;
			prev = curt;
			curt = temp;
		}
		
		head.next = prev;
		n1.next = nkplus;
		return n1;
	}
}
