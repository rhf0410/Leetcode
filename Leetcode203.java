package com.example.second;

public class Leetcode203 {
	/**
	 * Remove elements.
	 * @param head
	 * @param val
	 * @return
	 */
	public ListNode removeElements(ListNode head, int val) {
        if(head == null)
        	return null;
        ListNode new_head = new ListNode(0);
        new_head.next = head;
        ListNode node = new_head;
        while(node.next != null){
        	if(node.next.val == val){
        		node.next = node.next.next;
        	}else{
        		node = node.next;
        	}
        }
        return new_head.next;
    }
}
