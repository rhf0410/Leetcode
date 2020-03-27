package com.example.second;

public class Leetcode24 {
	/**
	 * Swap pairs.
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode(0);
        ListNode result = node;
        node.next = head;
        while(node.next != null && node.next.next != null){
        	ListNode node1 = node.next;
        	ListNode node2 = node.next.next;
        	node.next = node2;
        	node1.next = node2.next;
        	node2.next = node1;
        	node = node1;
        }
        return result.next;
    }
	
	public void addElement(ListNode l, int ele){
		ListNode node = l;
		while(node.next != null){
			node = node.next;
		}
		node.next = new ListNode(ele);
	}
	
	public void printList(ListNode head){
		ListNode ls = head;
		while(ls != null){
			System.out.println(ls.val);
			ls = ls.next;
		}
	}
}
