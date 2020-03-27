package com.example.second;

import java.util.Stack;

public class Leetcode114 {
	/**
	 * Flatten Binary tree to linked list.
	 * @param root
	 */
	public void flatten(TreeNode root) {
        if(root == null)
        	return;
        recursive(root);
    }
	
	private void recursive(TreeNode root){
		if(root == null)
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = null;
		recursive(left);
		recursive(right);
		root.right = left;
		TreeNode node = root;
		while(node.right != null){
			node = node.right;
		}
		node.right = right;
	}
	
	public void flatten2(TreeNode root) {
        if(root == null)
        	return;
        TreeNode node = root;
        while(node != null){
        	if(node.left != null){
        		TreeNode left = node.left;
        		while(left.right != null){
        			left = left.right;
        		}
        		left.right = node.right;
        		node.right = node.left;
        		node.left = null;
        	}
        	node = node.right;
        }
    }
}
