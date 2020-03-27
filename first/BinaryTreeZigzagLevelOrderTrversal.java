package com.example.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTrversal {
	/**
	 * Binary Tree Node
	 * @author lenovo
	 *
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/**
	 * Zigzag level order traversal
	 * @param root:given root
	 * @return
	 */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>result = new ArrayList<List<Integer>>();
        if(root == null)
    		return result;
        Queue<TreeNode>queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer>begin = new ArrayList<Integer>();
        
        begin.add(root.val);
        result.add(begin);
        boolean flag = true;
        while(!queue.isEmpty()){
        	List<Integer>list = new ArrayList<Integer>();
        	int n = queue.size();
        	for(int i=0;i<n;i++){
        		TreeNode node = queue.poll();
        		if(node.left != null){
    				list.add(node.left.val);
    				queue.add(node.left);
    			}
    			if(node.right != null){
    				list.add(node.right.val);
    				queue.add(node.right);
    			}
        	}
        	if(flag){
        		Collections.reverse(list);
        	}
        	flag = !flag;
        	if(list.size() != 0)
        		result.add(list);
        }
        return result;
    }
}
