package com.example.first;

import java.util.List;

import com.example.second.TreeNode;

public class FirstProgram {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = null;
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(4);
		theLongestPath tlp = new theLongestPath();
	}
}
