package com.algorimthms;

import java.util.Stack;

public class ReverseList {

}


class ReverseListSolution {
    /*
     * Recursion
    public ListNode reverseList(ListNode head) {
       if(head==null||head.next==null){
           return head;
       }
        
        ListNode newHead = reverseList(head.next);
        ListNode next = head.next;
        head.next = null;
        next.next = head;
        return newHead;
    }
    */
    
    /*
     * Iterator
    public ListNode reverseList(ListNode head){
        ListNode dummy = new ListNode(0);
        while(head!=null){
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
        
    }
    */
    
    //Using Stack
    public ListNode reverseList(ListNode head){
        if(head==null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        Stack<ListNode> stack = new Stack<ListNode>();
        while(head!=null){
            stack.add(head);
            head = head.next;
        }
        
        ListNode newHead = null;
        if(stack.size()!=0){
            newHead = stack.pop();
            dummy.next = newHead;
        }
        
        while(stack.size()!=0){
            newHead.next = stack.pop();
            newHead = newHead.next;
        }
        newHead.next = null;
        return dummy.next;
        
    }
}
