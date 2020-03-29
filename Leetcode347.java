package com.leetcode.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Leetcode347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer>res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0)
			return res;
		Map<Integer, List<Integer>>map = new TreeMap<Integer, List<Integer>>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		Map<Integer, Integer>mid = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++){
			if(!mid.containsKey(nums[i]))
				mid.put(nums[i], 1);
			else{
				int num = mid.get(nums[i]);
				mid.put(nums[i], ++num);
			}
		}
		
		Iterator<Integer>ite = mid.keySet().iterator();
		while(ite.hasNext()){
			int num = ite.next();
			int value = mid.get(num);
			List<Integer>link = null;
			if(!map.containsKey(value)){
				link = new ArrayList<Integer>();
			}else{
				link = map.get(value);
				
			}
			link.add(num);
			map.put(value, link);
		}

		for(Map.Entry<Integer, List<Integer>>entry: map.entrySet()){
			List<Integer>list = entry.getValue();
			res.addAll(list);
		}
		
		return res.subList(0, k);
    }
	
}
