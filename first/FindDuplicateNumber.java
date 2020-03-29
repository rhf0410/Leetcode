package com.example.first;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindDuplicateNumber {
	/**
	 * Find the duplicate number.
	 * @param nums
	 * @return
	 */
	public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
        	slow = nums[slow];
        	fast = nums[nums[fast]];
        }while(slow != fast);
        fast = 0;
        while(fast != slow){
        	fast = nums[fast];
        	slow = nums[slow];
        }
        return slow;
    }
}
