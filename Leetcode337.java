package com.example.second;

public class Leetcode337 {
	/**
	 * House Robber III.
	 * @param root
	 * @return
	 */
	public int rob(TreeNode root) {
       if(root == null)
    	   return 0;
       int [] res = getMaxNode(root);
       return Math.max(res[0], res[1]);
    }
	
	private int [] getMaxNode(TreeNode root){
		int [] res = new int [2];
		if(root == null)
			return res;
		int [] left = getMaxNode(root.left);
		int [] right = getMaxNode(root.right);
		res[0] = root.val + left[1] + right[1];
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return res;
	}
}
