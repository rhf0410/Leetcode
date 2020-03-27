package com.example.second;

public class Leetcode124 {
	/**
	 * Bianry tree maximum path sum;
	 * @param root
	 * @return
	 */
	private int max = Integer.MIN_VALUE;
	private class newTreeNode{
		TreeNode node;
		newTreeNode left;
		newTreeNode right;
		int sum;
		newTreeNode(TreeNode node){
			this.node = node;
			this.sum = 0;
		}
	}
	
	public int maxPathSum(TreeNode root) {
        if(root == null)
        	return 0;
        return maxside(root);
    }
	
	public newTreeNode linkTree(TreeNode root){
		if(root == null)
			return null;
		newTreeNode newnod = new newTreeNode(root);
		if(root.left == null && root.right == null){
			newnod.sum = root.val;
			return newnod;
		}
		newnod.left = linkTree(root.left);
		newnod.right = linkTree(root.right);
		newnod.sum = newnod.node.val;
		if(newnod.left != null){
			newnod.sum = Math.max(newnod.sum, newnod.sum + newnod.left.sum);
		}
		if(newnod.right != null){
			newnod.sum = Math.max(newnod.sum, newnod.sum + newnod.right.sum);
		}
		return newnod;
	}
	
	private int maxsub(newTreeNode root){
		if(root == null)
			return Integer.MIN_VALUE;
		if(root.left == null && root.right == null){
			return root.sum;
		}
		int leftmax = Math.max(root.sum, maxsub(root.left));
		int rightmax = Math.max(root.sum, maxsub(root.right));
		return Math.max(leftmax, rightmax);
	}

	private int maxside(TreeNode root){
		if(root == null)
			return 0;
		int left = maxside(root.left);
		int right = maxside(root.right);
		max = Math.max(max, left + right + root.val);
		return Math.max(0, root.val + Math.max(left, right));
	}
}
