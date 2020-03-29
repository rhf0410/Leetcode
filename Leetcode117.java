package com.example.second;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode117 {
	/**
	 * Populating Next Right Pointers in Each Node II.
	 * @param root
	 */
	public void connect(TreeLinkNode root) {
        if(root == null)
        	return;
        Queue<TreeLinkNode>queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int size = queue.size();
        	TreeLinkNode rnode = queue.peek();
        	for(int i=0;i<size;i++){
        		TreeLinkNode node = queue.poll();
        		if(i != 0){
        			rnode.next = node;
        			rnode = rnode.next;
        		}
        		if(node.left != null){
        			queue.add(node.left);
        		}
        		if(node.right != null){
        			queue.add(node.right);
        		}
        	}
        	rnode.next = null;
        }
    }
	
	public void connect2(TreeLinkNode root){
		if(root == null)
			return;
		TreeLinkNode node = new TreeLinkNode(0);
		TreeLinkNode pre = node;
		while(root != null){
			if(root.left != null){
				pre.next = root.left;
				pre = pre.next;
			}
			if(root.right != null){
				pre.next = root.right;
				pre = pre.next;
			}
			root = root.next;
			if(root == null){
				root = node.next;
				pre = node;
				node.next = null;
			}
		}
	}
}
