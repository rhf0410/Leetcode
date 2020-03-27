package com.example.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Leetcode508 {
	/**
	 * Most Frequent Subtree Sum.
	 * @param root
	 * @return
	 */
	public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer>map = new HashMap<Integer, Integer>();
        int max = statisticSum(root, map, 0);
        Iterator<Integer>ite = map.keySet().iterator();
        List<Integer>result = new ArrayList<Integer>();
        while(ite.hasNext()){
        	int i = ite.next();
        	if(map.get(i) == max){
        		result.add(i);
        	}
        }
        int [] nums = new int [result.size()];
        for(int i=0;i<result.size();i++)
        	nums[i] = result.get(i);
        return nums;
    }
	
	private int statisticSum(TreeNode root, Map<Integer, Integer> map, int max){
		if(root != null){
			int sum = this.sumTree(root);
			if(map.containsKey(sum)){
				int value = map.get(sum) + 1;
				map.put(sum, value);
			}else{
				map.put(sum, 1);
			}
			if(map.get(sum) > max){
				max = map.get(sum);
			}
			if(root.left != null)
				max = Math.max(max, statisticSum(root.left, map, max));
			if(root.right != null)
				max = Math.max(max, statisticSum(root.right, map, max));
		}
		return max;
	}
	
	private int sumTree(TreeNode root){
		int sum = root.val;
		if(root.left != null)
			sum += sumTree(root.left);
		if(root.right != null)
			sum += sumTree(root.right);
		return sum;
	}
}
