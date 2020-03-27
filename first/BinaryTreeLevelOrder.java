package com.example.first;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>results = new ArrayList<List<Integer>>();
        if(root == null)
        	return results;
        TreeNode p = root;
        Queue<TreeNode>queue = new LinkedList<TreeNode>();
        queue.add(p);
        while(!queue.isEmpty()){
        	List<Integer>list = new ArrayList<Integer>();
        	int n = queue.size();
        	for(int i=0;i<n;i++){
        		TreeNode q = queue.poll();
            	list.add(q.val);
            	if(q.left != null)
            		queue.add(q.left);
            	if(q.right != null)
            		queue.add(q.right);
        	}
            if(!list.isEmpty())
                results.add(list);
        }
        return results;
    }
}
