package com.example.first;

public class RotateList {
	/**
	 * Rotate list.
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null){
			return null;
		}
		if(head.next == null){
			return head;
		}
		ListNode previous = head;
		ListNode next = head.next;
		ListNode node = head;
		int length = 1;
		while(node.next != null){
			length++;
			node = node.next;
		}
		int newk = k%length;
		int count = 1;
		while(length - count != newk){
			previous = previous.next;
			count++;
		}
		node.next = head;
		head = previous.next;
		previous.next = null;
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
			System.out.println(ls.val);
			ls = ls.next;
		}
	}
}
