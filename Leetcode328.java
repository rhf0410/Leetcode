package com.example.second;

public class Leetcode328 {
	/**
	 * Odd even links.
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList(ListNode head) {
        if(head == null)
        	return null;
        if(head.next == null)
        	return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode odd1 = odd;
        ListNode even1 = even;
        ListNode node = even;
        int k=1;
        while(node.next != null){
        	if(k%2 == 1){
        		odd.next = node.next;
        		odd = odd.next;
        	}else{
        		even.next = node.next;
        		even = even.next;
        	}
        	node = node.next;
        	k++;
        }
        odd.next = even1;
        this.printList(odd1);
        return odd1;
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
