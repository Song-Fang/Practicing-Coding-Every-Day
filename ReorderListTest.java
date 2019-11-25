package com.algorimthms;

public class ReorderListTest {
	public static void main(String [] args) {
		ReorderSolution rs = new ReorderSolution();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		
		rs.reorderList(node1);
		
		System.out.println(node1.val);
		System.out.println(node1.next.val);
		System.out.println(node1.next.next.val);
		System.out.println(node1.next.next.next.val);
		System.out.println(node1.next.next.next.next.val);
		System.out.println(node1.next.next.next.next.next);
		
		
	}
}

class ReorderSolution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode dummyNode = new ListNode(0);
        ListNode curt = dummyNode;
        ListNode node = slow;
        while(node!=null){
            ListNode next = node.next;
            node.next = curt.next;
            curt.next = node;
            node = next;  
        }
        
        ListNode p1 = head;
        ListNode p2 = dummyNode.next;
        while(p1!=slow){
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            p1.next = p2;
            p2.next = next1;
            p1 = next1;
            p2=next2;
            
        }
    }
}
