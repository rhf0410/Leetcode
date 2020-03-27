package com.example.second;

import java.util.Stack;

public class Leetcode430 {
	/**
	 * Flatten a Multilevel Doubly Linked List
	 * @param head
	 * @return
	 */
	public Node flatten(Node head) {
        if(head == null){
        	return null;
        }
        Stack<Node>stack = new Stack<Node>();
        Node node = head;
        while(!stack.isEmpty() || node != null){
        	if(node.next == null && !stack.isEmpty()){
        		Node rnode = stack.pop();
        		Node rnode1 = rnode.child;
        		Node rnode2 = rnode.next;
        		rnode.next = rnode1;
        		rnode1.prev = rnode;
        		rnode.child = null;
        		node.next = rnode2;
        		if(rnode2 != null)
        			rnode2.prev = node;
        	}
        	if(node.child != null){
        		stack.push(node);
        		node = node.child;
        		continue;
        	}
        }
        return head;
    }
}
