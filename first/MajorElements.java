package com.example.first;

import java.util.HashMap;
import java.util.Iterator;

public class MajorElements {
	/**
	 * Find the major element.
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        HashMap<Integer,Integer>hash = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
        	if(!hash.containsKey(nums[i])){
        		hash.put(nums[i], 0);
        	}else{
        		hash.put(nums[i], hash.get(nums[i]) + 1);
        	}
        }
        int n = nums.length;
        Iterator<Integer>ite = hash.keySet().iterator();
        while(ite.hasNext()){
        	int num = ite.next();
        	if(hash.get(num) >= n/2){
        		n = num;
        		break;
        	}
        }
        return n;
    }
}
