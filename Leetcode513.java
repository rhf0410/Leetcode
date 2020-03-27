package com.example.second;

public class Leetcode513 {
	private int layer = 1;
	/**
	 * Find Bottom Left Tree Value
	 * @param root
	 * @return
	 */
	public int findBottomLeftValue(TreeNode root) {
        if(root == null){
        	return 0;
        }
        int maxLayer = 0;
        TreeNode node = root;
        maxLayer = this.maxL(node, 1, node.val);
        return maxLayer;
    }
	
	private int maxL(TreeNode node, int number, int max){
		int new_max = max;
		if(node == null){
			return new_max;
		}
		if(node.left == null && node.right == null){
			if(number > this.layer){
				this.layer = number;
				return node.val;
			}
		}
		if(node.left != null){
			new_max = maxL(node.left, number + 1, new_max);
		}
		if(node.right != null){
			new_max = maxL(node.right, number + 1, new_max);
		}
		return new_max;
	}
}
