package com.example.second;

public class Leetcode421 {
	/**
	 * Maximum XOR of Two Numbers in an Array.
	 * @param nums
	 * @return
	 */
	class Tire{
		Tire [] children;
		public Tire(){
			children = new Tire[2];
		}
	}
	
	public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        Tire root = new Tire();
        for(int num: nums){
        	Tire node = root;
        	for(int i=31;i>=0;i--){
        		int curbit = (num >> i) & 1;
        		if(node.children[curbit] == null){
        			node.children[curbit] = new Tire();
        		}
        		node = node.children[curbit];
        	}
        }
        int max = Integer.MIN_VALUE;
        for(int num:nums){
        	int sum = 0;
        	Tire node = root;
        	for(int i=31;i>=0;i--){
        		int curbit = (num >> i) & 1;
        		if(node.children[curbit^1] != null){
        			sum += 1 << i;
        			node = node.children[curbit^1];
        		}else{
        			node = node.children[curbit];
        		}
        	}
        	max = Math.max(max, sum);
        }
        return max;
    }
}
