package com.example.second;

import com.example.second.ListNode;

public class Leetcode86 {
	/**
	 * Partition list.
	 * @param head
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
		if(head == null)
			return null;
        ListNode node = head;
        ListNode large = new ListNode(0);
        ListNode small = new ListNode(0);
        ListNode h_large = large;
        ListNode h_small = small;
        while(node != null){
        	if(node.val < x){
        		small.next = node;
        		small = small.next;
        	}else{
        		large.next = node;
        		large = large.next;
        	}
        	node = node.next;
        }
        small.next = h_large.next;
        large.next = null;
        return h_small.next;
    }
	
	public void addElement(ListNode head, int ele){
		ListNode node = head;
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
