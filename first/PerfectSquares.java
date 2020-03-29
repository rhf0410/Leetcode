package com.example.first;

import java.util.Arrays;

public class PerfectSquares {
	/**
	 * Find the number of squares
	 * @param n:given number
	 * @return
	 */
	public int numSquares(int n) {
        int [] squares = new int [n+1];
        Arrays.fill(squares, Integer.MAX_VALUE);
        squares[0] = 0;
        for(int i=1;i<=n;i++){
        	for(int j=1;j * j<=i;j++){
        		squares[i] = Math.min(squares[i - j*j] + 1, squares[i]);
        	}
        }
        return squares[n];
    }
}
