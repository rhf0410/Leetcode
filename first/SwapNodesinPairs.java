package com.example.first;

public class SwapNodesinPairs {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	
    public ListNode swapPairs(ListNode head) {
    	if(head == null)
    		return null;
    	
    	ListNode start1 = head;
    	ListNode start2 = head.next;
    	ListNode link = head.next;
    	while(link.next != null){
    		head.next = link.next;
    		link.next = link.next.next;
    		link = link.next;
    		head = head.next;
    	}
    	
    	ListNode start = head;
    	start1 = start1.next;
    	while(start1 != null){
    		ListNode l = start2;
    		start2 = start2.next;
    		if(start1.next != null)
    		    l.next = start1.next;
    		start1.next = l;
    		start1 = l.next;
    	}
        return start;
    }
}
