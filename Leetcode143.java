package com.example.second;

import java.util.List;

public class Leetcode143 {
	/**
	 * Reordered list.
	 * @param head
	 */
	public void reorderList(ListNode head) {
        if(head == null || head.next == null)
        	return;
        int length = length(head)/2;
        ListNode tail = new ListNode(0);
        tail.next = head;
        for(int i=0;i<length;i++){
        	tail = tail.next;
        }
        ListNode cur = tail.next;
        tail.next = null;
        ListNode new_cur = new ListNode(0);
        new_cur.next = cur;
        ListNode post = cur.next;
        while(post != null){
        	cur.next = post.next;
        	post.next = new_cur.next;
        	new_cur.next = post;
        	post = cur.next;
        }
        ListNode node1 = head;
        ListNode node2 = new_cur.next;
        while(node1 != null){
        	ListNode mnode = node1.next;
        	node1.next = node2;
        	ListNode nnode = node2.next;
        	if(mnode == null)
        		break;
        	node2.next = mnode;
        	node1 = mnode;
        	node2 = nnode;
        }
    }
	
	public int length(ListNode head){
		int length = 0;
		ListNode node = head;
		while(node != null){
			node = node.next;
			length++;
		}
		return length;
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
