package com.example.first;

public class HIndexII {
	/**
	 * H Index II.
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
        	return 0;
        int result = 0;
        int length = citations.length;
        int left = 0;
        int right = citations.length - 1;
        while(left <= right){
        	int mid = left + (right - left)/2;
        	if(citations[mid] >= length - mid){
        		result = length - mid;
        		right = mid - 1;
        	}else{
        		left = mid + 1;
        	}
        }
        return result;
    }
}
