package com.example.first;

public class RemoveDuplicatesfromSortedListII {
	/**
	 * Remove duplicate elements from sorted list.
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return null;
		ListNode node = new ListNode(0);
		node.next = head;
		ListNode previous = node;
		ListNode next = node.next;
		while(next.next != null){
			if(next.val == next.next.val){
				while(next.next != null && next.val == next.next.val){
					next = next.next;
				}
				if(next.next == null){
					previous.next = null;
					break;
				}
				previous.next = next.next;
				next = next.next;
			}else{
				previous = next;
				next = next.next;
			}
		}
		return node.next;
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
