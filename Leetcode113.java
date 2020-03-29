package com.example.second;

import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
	/**
	 * Path Sum III.
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>>result = new ArrayList<List<Integer>>();
        if(root == null)
			return result;
        List<Integer>list = new ArrayList<Integer>();
        recursive(sum, 0, root, result, list);
        return result;
    }
	
	private void recursive(int sum, int n, TreeNode node, List<List<Integer>>result, List<Integer>list){
		if(node == null){
			return;
		}
		n += node.val;
		list.add(node.val);
		if(node.left == null && node.right == null){
			if(n == sum){
				List<Integer>list1 = new ArrayList<Integer>();
				list1.addAll(list);
				result.add(list1);
				list.remove(list.size() - 1);
				return;
			}else{
				list.remove(list.size() - 1);
				return;
			}
		}
		recursive(sum, n, node.left, result, list);
		recursive(sum, n, node.right, result, list);
		if(list.size() > 0){
			list.remove(list.size() - 1);
		}
	}
}
