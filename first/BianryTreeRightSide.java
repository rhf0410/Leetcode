package com.example.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BianryTreeRightSide {

	 //Definition for a binary tree node.
	 public class TreeNode {
		 int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	/**
	 * Find right side view
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer>result = new ArrayList<Integer>();
		if(root == null)
			return result;
		LinkedList<TreeNode>queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int size = queue.size();
        	result.add(queue.get(size-1).val);
        	for(int i=0;i<size;i++){
        		TreeNode node = queue.poll();
        		if(node.left != null){
        			queue.add(node.left);
        		}
            	if(node.right != null){
            		queue.add(node.right);
            	}
        	}
        }
        return result;
    }
	
	/**
	 * Find nodes by recursion
	 * @param root
	 * @param result
	 */
	private void recursive(TreeNode root, List<Integer>result){
		result.add(root.val);
		if(root.left == null && root.right == null)
			return;
		if(root.right != null)
			recursive(root.right, result);
		if(root.left != null)
			recursive(root.left, result);
	}
}
