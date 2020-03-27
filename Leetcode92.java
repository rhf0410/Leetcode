package com.example.second;

public class Leetcode92 {
	/**
	 * Reverse link.
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head == null)
			return null;
		ListNode new_head = new ListNode(0);
		new_head.next = head;
		ListNode node1 = new_head;
		for(int i=0;i<m-1;i++){
			node1 = node1.next;
		}
		ListNode node2 = node1.next;
		int [] nums = new int [n-m+1];
		int k=0;
		for(int j=m;j<=n;j++){
			nums[k++] = node2.val;
			node2 = node2.next;
		}
		ListNode new_node = new ListNode(0);
		ListNode node = new_node;
		for(int i=nums.length-1;i>=0;i--){
			node.next = new ListNode(nums[i]);
			node = node.next;
		}
		node.next = node2;
		node1.next = new_node.next;
		if(m == 1){
			head = new_node.next;
		}
		this.printList(head);
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
