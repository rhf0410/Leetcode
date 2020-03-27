package com.example.second;

import java.util.LinkedList;
import java.util.Stack;

public class Leetcode445 {
	/**
	 * Add two numbers.
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer>stack1 = new Stack<Integer>();
        Stack<Integer>stack2 = new Stack<Integer>();
        ListNode node = l1;
        while(node != null){
        	stack1.add(node.val);
        	node = node.next;
        }
        node = l2;
        while(node != null){
        	stack2.add(node.val);
        	node = node.next;
        }
        int k=0;
        ListNode head = new ListNode(0);
        while(!stack1.isEmpty()||!stack2.isEmpty()){
        	int sum = 0;
        	if(!stack1.isEmpty()){
        		sum += stack1.pop();
        	}
        	if(!stack2.isEmpty()){
        		sum += stack2.pop();
        	}
        	sum += k;
        	ListNode newnode = new ListNode(sum%10);
        	newnode.next = head.next;
        	head.next = newnode;
        	k = sum/10;
        }
        if(k!=0){
        	ListNode newnode = new ListNode(k);
        	newnode.next = head.next;
        	head.next = newnode;
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
