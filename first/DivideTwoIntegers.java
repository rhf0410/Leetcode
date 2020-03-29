package com.example.first;

public class DivideTwoIntegers {
	/**
	 * Divide two integers with unsing multiplication and divisor.
	 * @param dividend
	 * @param divisor
	 * @return
	 */
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
        	return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE){
        	if(divisor == -1)
        		return Integer.MAX_VALUE;
        }
        int sign = 1;
        long divd = (long)dividend;
        long divs = (long)divisor;
        if(divd  < 0){
        	divd = -divd;
        	sign = -sign;
        }
        if(divs < 0){
        	divs = -divs;
        	sign = -sign;
        }
        
        int result = 0;
        while(divd >= divs){
        	long shift = 0;
        	while((divs << shift) <= divd){
        		shift++;
        	}
        	result += 1 << (shift-1);
        	divd -= divs << (shift-1);
        }
        return result * sign;
    }
}
