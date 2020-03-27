package com.example.second;

public class Leetcode338 {
	/**
	 * Counting bits.
	 * @param num
	 * @return
	 */
	public int[] countBits(int num) {
        int [] nums = new int [num + 1];
        /*for(int i=0;i<=num;i++){
        	nums[i] = numberofones(i);
        }*/
        for(int i=0;i<=num;i++){
        	nums[i] = nums[i/2] + (num & 1);
        }
        return nums;
    }
	
	public int numberofones(int num){
		int count = 0;
		while(num != 0){
			if((num & 1) == 1){
				count++;
			}
			num >>=1;
		}
		return count;
	}
}
