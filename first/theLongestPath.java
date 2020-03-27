package com.example.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class theLongestPath {
	/**
	 * Return the longest tree path.
	 * @param root
	 * @return
	 */
	public List<String> theLongest(TreeNode root){
		List<String>res = new ArrayList<String>();
		if(root == null){
			return res;
		}
		Queue<TreeNode>queue = new LinkedList<TreeNode>();
		HashMap<Integer, List<List<TreeNode>>>path = new HashMap<Integer, List<List<TreeNode>>>();
		queue.add(root);
		int number = 1;
		
		List<List<TreeNode>>paths = new ArrayList<List<TreeNode>>();
		List<TreeNode>nodes = new ArrayList<TreeNode>();
		nodes.add(root);
		paths.add(nodes);
		path.put(number, paths);
		
		while(!queue.isEmpty()){
			int num = queue.size();
			while(num-- != 0){
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.add(node.left);
					List<List<TreeNode>>paths2 = path.get(number);
					for(int i=0;i<paths2.size();i++){
						int length = paths2.get(i).size() - 1;
						if(paths2.get(i).get(length).left == node.left || 
								paths2.get(i).get(length).right == node.left){
							List<TreeNode>path2 = paths2.get(i);
							path2.add(node.left);
							if(path.containsKey(number + 1)){
								path.get(number + 1).add(path2);
							}else{
								List<List<TreeNode>>new_paths = new ArrayList<List<TreeNode>>();
								new_paths.add(path2);
								path.put(number + 1, new_paths);
							}
						}
					}
				}
				if(node.right != null){
					queue.add(node.right);
					List<List<TreeNode>>paths2 = path.get(number);
					for(int i=0;i<paths2.size();i++){
						int length = paths2.get(i).size() - 1;
						if(paths2.get(i).get(length).left == node.right || 
								paths2.get(i).get(length).right == node.right){
							List<TreeNode>path2 = paths2.get(i);
							path2.add(node.right);
							if(path.containsKey(number + 1)){
								path.get(number + 1).add(path2);
							}else{
								List<List<TreeNode>>new_paths = new ArrayList<List<TreeNode>>();
								new_paths.add(path2);
								path.put(number + 1, new_paths);
							}
						}
					}
				}
			}
			number++;
		}

		List<List<TreeNode>>lists = path.get(number);
		for(int i=0;i<lists.size();i++){
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<lists.get(i).size();j++){
				sb.append(lists.get(i).get(j));
			}
			res.add(sb.toString());
		}
		return res;
	}
}
