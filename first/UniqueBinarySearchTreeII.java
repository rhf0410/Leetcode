package com.example.first;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreeII {
   /**
	* Tree Node
	* @author lenovo
	*
	*/
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
        
    }
	
	/**
	 * Find nodes of binary search tree
	 * @param min
	 * @param max
	 * @return
	 */
	private List<TreeNode>helper(int min, int max){
		List<TreeNode>results = new ArrayList<TreeNode>();
		if(min > max){
			return results;
		}
		for(int rt = min;rt <= max;rt++){
			List<TreeNode>left = helper(min, rt-1);
			List<TreeNode>right = helper(rt+1, max);
			if(left.size() == 0 && right.size() == 0){
				TreeNode root = new TreeNode(rt);
				results.add(root);
			}else if(right.size() == 0){
				for(TreeNode leftnode : left){
					TreeNode root = new TreeNode(rt);
					root.left = leftnode;
					results.add(root);
				}
			}else if(left.size() == 0){
				for(TreeNode rightnode : right){
					TreeNode root = new TreeNode(rt);
					root.right = rightnode;
					results.add(root);
				}
			}else{
				for(TreeNode leftnode : left){
					for(TreeNode rightnode : right){
						TreeNode root = new TreeNode(rt);
						root.left = leftnode;
						root.right = rightnode;
						results.add(root);
					}
				}
			}
		}
		return results;
	}
}
