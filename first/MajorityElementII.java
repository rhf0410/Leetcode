package com.example.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer>result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0)
        	return result;
        Double size  = Math.floor(nums.length / 3);
        int new_size = size.intValue();
        Map<Integer, Integer>map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
        	if(map.containsKey(nums[i])){
        		int num = map.get(nums[i]) + 1;
        		map.put(nums[i], num);
        	}else{
        		map.put(nums[i], 1);
        	}
        }
        Iterator<Integer>ite = map.keySet().iterator();
        while(ite.hasNext()){
        	int mnum = ite.next();
        	if(map.get(mnum) > new_size){
        		result.add(mnum);
        	}
        }
        return result;
    }
}
