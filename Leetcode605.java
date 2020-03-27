package com.example.second;

public class Leetcode605 {
	/**
	 * Can place flowers.
	 * @param flowerbed
	 * @param n
	 * @return
	 */
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0)
        	return false;
        for(int i=0;i<flowerbed.length&&n>0;i++){
        	if((flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0)) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)){
        		flowerbed[i] = 1;
        		n--;
        	}
        }
        return n==0;
    }
	
	private boolean recursive(int[] flowerbed, int n){
		if(n == 0){
			for(int i=0;i<flowerbed.length - 1;i++){
				if(flowerbed[i] == 1 && flowerbed[i+1] == 1)
					return false;
			}
			return true;
		}
		boolean flag = false;
		for(int i=0;i<flowerbed.length;i++){
			if(flowerbed[i] == 0){
				flowerbed[i] = 1;
				flag = flag || recursive(flowerbed, n-1);
				flowerbed[i] = 0;
			}
		}
		return flag;
	}
}
