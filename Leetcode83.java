package com.example.second;

public class Leetcode83 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
        	return null;
        ListNode node = head;
        ListNode result = head;
        while(node != null){
        	if(node.next != null && node.val == node.next.val){
        		node.next = node.next.next;
        	}else{
        		node = node.next;
        	}
        }
        return result;
    }
	
	public ListNode deleteDuplicates2(ListNode head){
		if(head == null)
			return null;
		ListNode node = head;
		while(node.next != null && node.val == node.next.val){
			node.next = node.next.next;
		}
		head.next = deleteDuplicates2(node.next);
		return head;
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
			System.out.print(ls.val + " ");
			ls = ls.next;
		}
	}
}
