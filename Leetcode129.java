package com.example.second;

import java.util.List;
import java.util.Stack;

public class Leetcode129 {
	/**
	 * Sum Root to Leaf Numbers.
	 * @param root
	 * @return
	 */
	public int sumNumbers(TreeNode root) {
        if(root == null)
        	return 0;
        return recursive(root, 0);
    }

	private int recursive(TreeNode root, int sum){
		if(root == null)
			return 0;
		sum = sum * 10 + root.val;
		if(root.left == null && root.right == null){
			return sum;
		}
		int num1 = recursive(root.left, sum);
		int num2 = recursive(root.right, sum);
		return num1 + num2;
	}
}
