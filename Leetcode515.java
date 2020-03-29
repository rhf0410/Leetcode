package com.example.second;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode515 {
	/**
	 * Find Largest Value in Each Tree Row.
	 * @param root
	 * @return
	 */
	public List<Integer> largestValues(TreeNode root) {
        List<Integer>result = new ArrayList<Integer>();
        if(root == null){
        	return result;
        }
        this.maxLayer(root, 0, result);
        return result;
    }
	
	private void maxLayer(TreeNode node, int layer, List<Integer>result){
		if(node == null){
			return;
		}
		if(layer == result.size()){
			result.add(node.val);
		}else{
			result.set(layer, Math.max(result.get(layer), node.val));
		}
		maxLayer(node.left, layer+1, result);
		maxLayer(node.right, layer+1, result);
	}
}
