package com.example.second;

public class Leetcode105 {
	/**
	 * Construct Binary Tree from Preorder and Inorder Traversal.
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = returnNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
        return root;
    }
	
	public TreeNode returnNode(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2){
		if(start1 == end1 || start2 == end2)
			return null;
		TreeNode node = new TreeNode(postorder[end2-1]);
		int value = postorder[end2 - 1];
		int mid = start1;
		for(int i=start1;i<end1;i++){
			if(inorder[i] == value){
				mid = i;
				break;
			}
		}
		node.left = returnNode(inorder, start1, mid, postorder, start2, mid);
		node.right = returnNode(inorder, mid+1, end1, postorder, mid, end2-1);
		return node;
	}
}
