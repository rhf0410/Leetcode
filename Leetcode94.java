package com.example.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode94 {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<Integer>();
        if(root == null){
        	return result;
        }
        Stack<TreeNode>stack = new Stack<TreeNode>();
        TreeNode node = root;
        while(!stack.isEmpty() || node != null){
        	while(node != null){
        		stack.add(node);
        		result.add(node.val);
        		node = node.left;
        	}
        	if(!stack.isEmpty()){
        		node = stack.pop();
        		node = node.right;
        	}
        }
        return result;
    }
}
