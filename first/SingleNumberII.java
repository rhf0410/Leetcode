package com.example.first;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumberII {
	/**
	 * Single Number II.
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
        Map<Integer, Integer>map = new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
        	if(map.containsKey(nums[i])){
        		int num = map.get(nums[i]) + 1;
        		map.put(nums[i], num);
        	}else{
        		map.put(nums[i], 1);
        	}
        }
        int result = 0;
        Iterator<Integer>ite = map.keySet().iterator();
        while(ite.hasNext()){
        	int num = ite.next();
        	if(map.get(num) == 1){
        		result = num;
        		break;
        	}
        }
        return result;
    }
	
	public int singleNumber2(int[] nums){
		int result = 0;
		int [] count = new int [Integer.MAX_VALUE];
		for(int i=0;i<nums.length;i++){
			count[nums[i]]++;
		}
		for(int i=0;i<count.length;i++){
			if(count[i] == 1){
				result = i;
				break;
			}
		}
		return result;
	}
	
	public int singleNumber3(int[] nums){
		int result = 0;
		for(int i=0;i<32;i++){
			int bit = 1;
			bit <<= i;
			int count = 0;
			for(int j=0;j<nums.length;j++){
				if((bit&nums[j]) != 0){
					count++;
				}
			}
			if(count %3 != 0){
				result |= bit;
			}
		}
		return result;
	}
	
	public int singleNumber4(int[] nums){
		int ones = 0;
		int twos = 0;
		int numthrees = 0;
		for(int i=0;i<nums.length;i++){
			twos |= (ones&nums[i]);
			ones ^= nums[i];
			numthrees = ~(ones&twos);
			ones &= numthrees;
			twos &= numthrees;
		}
		return ones;
	}
}
