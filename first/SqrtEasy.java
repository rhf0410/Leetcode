package com.example.first;

import java.math.BigInteger;

public class SqrtEasy {
	/**
	 * Calculating sqrt.
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
		if(x <= 0)
			return 0;
		int start = 1;
		int end = x;
		while(start <= end){
			int mid = start + (end - start)/2;
			int m1 = x/mid;
			int m2 = x/(mid + 1);
			
			if(mid == m1)
				return m1;
			if(mid + 1 == m2)
				return mid + 1;
			if(m1 > mid && (mid + 1) > m2){
				return mid;
			}
			
			if(m1 < mid){
				end = mid;
			}else{
				start = mid + 1;
			}
		}
        return 1;
    }
}
