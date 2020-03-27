package com.example.second;

public class Leetcode2 {
	/**
	 * Add two numbers.
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode head = sum;
        ListNode node1 = l1;
        ListNode node2 = l2;
        int k = 0;
        while(node1 != null && node2 != null){
        	ListNode snode = new ListNode((node1.val + node2.val + k)%10 );
        	sum.next = snode;
        	sum = sum.next;
        	k = (node1.val + node2.val + k)/10;
        	node1 = node1.next;
        	node2 = node2.next;
        }
        while(node1 != null){
        	ListNode snode = new ListNode((node1.val + k)%10);
        	sum.next = snode;
        	sum = sum.next;
        	k = (node1.val + k)/10;
        	node1 = node1.next;
        }
        while(node2 != null){
        	ListNode snode = new ListNode((node2.val + k)%10);
        	sum.next = snode;
        	sum = sum.next;
        	k = (node2.val + k)/10;
        	node2 = node2.next;
        }
        if(k != 0){
        	ListNode snode = new ListNode(k);
        	sum.next = snode;
        }
        return head.next;
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