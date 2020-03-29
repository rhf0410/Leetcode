package com.example.second;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode236 {
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	/**
	 * Lowest common ancestor of a binary tree.
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode node = null;
		if(root == null)
        	return node;
        Queue<TreeNode>queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	TreeNode rnode = queue.poll();
        	if(findNode(rnode, p) && findNode(rnode, q)){
        		node = rnode;
        	}
        	if(rnode.left != null){
        		queue.add(rnode.left);
        	}
        	if(rnode.right != null){
        		queue.add(rnode.right);
        	}
        }
        return node;
    }
	
	private boolean findNode(TreeNode root, TreeNode p){
		boolean flag = false;
		if(root != null){
			if(root == p)
				return true;
			else{
				if(root.left != null)
					flag = flag || findNode(root.left, p);
				if(root.right != null)
					flag = flag || findNode(root.right, p);
			}
		}
		return flag;
	}
}
