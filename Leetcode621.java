package com.example.second;

import java.util.Arrays;

public class Leetcode621 {
	/**
	 * Task Scheduler.
	 * @param tasks
	 * @param n
	 * @return
	 */
	public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)
        	return 0;
        int result = 0;
        int [] nums = new int [26];
        for(int i=0;i<tasks.length;i++){
        	nums[tasks[i] - 'A']++;
        }
        Arrays.sort(nums);
        int i = 25;
        while(i>=0 && nums[25] == nums[i]){
        	i--;
        }
        return Math.max((25-i) + (nums[25] - 1) * (n+1), tasks.length);
    }
}
