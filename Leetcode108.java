package com.example.second;

public class Leetcode108 {
	/**
	 * Convert sorted array to binary search tree.
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
        	return null;
        return findNode(nums, 0, nums.length-1);
    }
	
	private TreeNode findNode(int[] nums, int begin, int end){
		if(begin == end)
			return null;
		int n = (end - begin)/2;
		TreeNode root = new TreeNode(nums[n]);
		root.left = findNode(nums, begin, n);
		root.right = findNode(nums, n+1, end);
		return root;
	}
}
