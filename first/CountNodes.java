package com.example.first;

public class CountNodes {
	/**
	 * Count the number of nodes.
	 * @param root
	 * @return
	 */
	public int countNodes(TreeNode root) {
        if(root == null)
        	return 0;
        int left = depthHelper(root, true);
        int right = depthHelper(root, false);
        if(left == right){
        	return (1<<left)-1;
        }else{
        	return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
	
	private int depthHelper(TreeNode root, boolean isLeft){
		if(root == null)
			return 0;
		return 1 + (isLeft ? depthHelper(root.left, isLeft) : depthHelper(root.right, isLeft));
	}
}
