package com.example.first;

import java.util.Arrays;

public class HIndex {
	/**
	 * Computing H_index.
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
        	return 0;
        }
        Arrays.sort(citations);
        int hindex = 0;
        for(int i=0;i<citations.length;i++){
        	if(citations[i] <= citations.length - i)
        	hindex = Math.max(hindex, Math.min(citations[i], citations.length - i));
        }
        return hindex;
    }
}
