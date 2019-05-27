package com.algorimthms;

public class ReverseKGroup {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		print(n1);
		
		KGroupSolution ks = new KGroupSolution();
		ListNode newNode = ks.reverseKGroup(n1, 2);
		print(newNode);

	}

	private static void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("null");
	}
}

class KGroupSolution {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curt = dummy;
		while (curt != null) {
			curt = reverseNextK(curt, k);
		}

		return dummy.next;
	}

	private ListNode reverseNextK(ListNode head, int k) {
		ListNode n1 = head.next;
		ListNode nk = head;
		for (int i = 0; i < k; i++) {
			nk = nk.next;
			if (nk == null) {
				return null;
			}
		}
		ListNode nkplus = nk.next;
		ListNode prev = null;
		ListNode curt = n1;
		while (curt != nkplus) {
			ListNode temp = curt.next;
			curt.next = prev;
			prev = curt;
			curt = temp;
		}
		head.next = nk;
		n1.next = nkplus;
		return n1;
	}
}
