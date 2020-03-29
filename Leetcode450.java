package com.example.second;

public class Leetcode450 {
	public class TreeNode {
	    int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/**
	 * Delete Node in a BST.
	 * @param root
	 * @param key
	 * @return
	 */
	public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
        	return null;
        }
        TreeNode result = root;
        TreeNode node = findNode(root, key);
        if(node.left == null && node.right == null){
        	node = null;
        }
        if(node.right != null){
        	TreeNode wait = node;
        	TreeNode pre = node;
        	node = node.right;
        	while(node.left != null){
        		pre = node;
        		node = node.left;
        	}
        	if(pre.right == node){
        		wait.val = node.val;
        		if(node.right != null){
            		pre.right = node.right;
            	}else{
            		pre.right = null;
            	}
        	}else{
        		wait.val = node.val;
            	if(node.right != null){
            		pre.left = node.right;
            	}else{
            		pre.left = null;
            	}
        	}
        }else{
        	TreeNode wait = node;
        	TreeNode pre = node;
        	node = node.left;
        	while(node.right != null){
        		pre = node;
        		node = node.right;
        	}
        	if(pre.left == node){
        		wait.val = node.val;
        		if(node.left != null){
            		pre.left = node.left;
            	}else{
            		pre.left = null;
            	}
        	}else{
        		wait.val = node.val;
            	if(node.left != null){
            		pre.right = node.left;
            	}else{
            		pre.right = null;
            	}
        	}
        }
        return result;
    }
	
	private TreeNode findNode(TreeNode root, int key){
		if(root.val == key){
			return root;
		}
		if(key < root.val){
			return findNode(root.left, key);
		}else{
			return findNode(root.right, key);
		}
	}
}
