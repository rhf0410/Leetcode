package com.example.second;

import java.util.HashSet;
import java.util.Set;

public class Leetcode817 {
	/**
	 * Linked list components.
	 * @param head
	 * @param G
	 * @return
	 */
	public int numComponents(ListNode head, int[] G) {
		if(head == null || G == null || G.length == 0)
			return 0;
        boolean flag = false;
        int num = 0;
        Set<Integer>set = new HashSet<Integer>();
        for(int i=0;i<G.length;i++){
        	set.add(G[i]);
        }
        ListNode node = head;
        while(node != null){
        	if(set.contains(node.val)){
        		if(flag){
        			node = node.next;
        			continue;
        		}
        		num++;
        		flag = true;
        	}else{
        		flag = false;
        	}
        	node = node.next;
        }
        return num;
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
