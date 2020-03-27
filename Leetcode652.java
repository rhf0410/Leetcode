package com.example.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode652 {
	/**
	 * Find duplicate subtrees.
	 * @param root
	 * @return
	 */
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode>result = new ArrayList<TreeNode>();
        if(root == null){
        	return result;
        }
        Map<String, Integer>map = new HashMap<String, Integer>();
        FindNode(root, result, map);
        return result;
    }
	
	public void FindNode(TreeNode root, List<TreeNode>list, Map<String, Integer>map){
		if(root != null){
			String str = preorder(root, "");
			if(map.containsKey(str)){
				map.put(str, map.get(str) + 1);
				if(map.get(str) == 1){
					list.add(root);
				}
			}else{
				map.put(str, 0);
			}
			FindNode(root.left, list, map);
			FindNode(root.right, list, map);
		}
	}
	
	public String preorder(TreeNode root, String res){
		String str = res;
		if(root != null){
			str += root.val;
			str = preorder(root.left, str);
			str = preorder(root.right, str);
		}
		return str;
	}
}
