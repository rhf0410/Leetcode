package com.example.second;

public class Leetcode98 {
	/**
	 * Validate binary search tree.
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
        if(root == null)
        	return true;
        return isBinarySearchTree(root);
    }
	
	private boolean isBinarySearchTree(TreeNode root){
		if(root == null)
			return true;
		boolean flag = true;
		if(root.left != null){
			flag = flag && LeftBinaryJudge(root.left, root.val) && isBinarySearchTree(root.left);
		}
		if(root.right != null){
			flag = flag && RightBinaryJudge(root.right, root.val) && isBinarySearchTree(root.right);
		}
		return flag;
	}
	
	public boolean LeftBinaryJudge(TreeNode root, int value){
		if(root == null)
			return true;
		if(root.val >= value)
			return false;
		else
			return LeftBinaryJudge(root.left, value) && LeftBinaryJudge(root.right, value);
	}
	
	public boolean RightBinaryJudge(TreeNode root, int value){
		if(root == null)
			return true;
		if(root.val <= value)
			return false;
		else
			return RightBinaryJudge(root.left, value) && RightBinaryJudge(root.right, value);
	}
}
