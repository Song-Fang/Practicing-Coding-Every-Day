package com.algorimthms;

public class CopyRandomPointer2 {
	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		print(n1);
		CopyRandomPointerSolution s = new CopyRandomPointerSolution();
		print(s.copyRandomList(n1));

	}

	private static void print(RandomListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}

		System.out.println("null");
	}
}

class CopyRandomPointerSolution {
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode dummy = new RandomListNode(0);
		dummy.next = head;
		RandomListNode newNode;
		while (head != null) {
			newNode = new RandomListNode(head.val);
			newNode.next = head.next;
			head.next = newNode;

			head = head.next.next;
		}
		
		head = dummy.next;

		while (head != null) {
			if (head.next.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}

//		while (head != null) {
//			RandomListNode temp = head.next.next;
//			head.next.next = head.next.next.next;
//			head = temp;
//		}
		
		head = dummy.next;
		RandomListNode newHead = dummy.next.next;
		
		while(head!=null) {
			RandomListNode temp = head.next;
			head.next = temp.next;
			head = head.next;
			if(temp.next!=null){
				temp.next = temp.next.next;
			}
		}

		return newHead;
	}
}
