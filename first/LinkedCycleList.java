package com.example.first;

public class LinkedCycleList {
	/**
	 * Find if there is a cycle in a list.
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != fast){
			if(fast == null)
				return false;
			slow = slow.next;
			if(fast.next != null && fast.next.next != null)
				fast = fast.next.next;
			else
				return false;
		}
        return true;
    }
	
	/**
	 * Detect Cycle.
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != fast){
			if(fast == null)
				return null;
			slow = slow.next;
			if(fast.next != null && fast.next.next != null)
				fast = fast.next.next;
			else
				return null;
		}
		slow = slow.next;
		fast = head;
		while(fast != slow){
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
    }
	
	public void addElement(ListNode head, int ele){
		ListNode node = head;
		while(node.next != null){
			node = node.next;
		}
		node.next = new ListNode(ele);
	}
}
