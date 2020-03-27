package com.example.first;

public class ContainerWithMostWater {
	/**
	 * Return the most water.
	 * @param height
	 * @return
	 */
    public int maxArea(int[] height) {
        if(height == null || height.length <= 2)
        	return 0;
        int result = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        while(i < j){
        	int area = (j - i) * Math.min(height[i], height[j]);
        	result = Math.max(result, area);
        	if(height[i] < height[j])
        		i++;
        	else
        		j--;
        }
        return result;
    }
}
