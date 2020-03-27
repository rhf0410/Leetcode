package com.leetcode.one;

public class Leetcode365 {
	public boolean solution(int x, int y, int z){
		boolean result = false;
		result = z == 0 || (x + y >= z) && (z % gcd(x, y) == 0);
		return result;
	}
	
	private int gcd(int x, int y){
		return y == 0 ? x : gcd(y, x%y);
	}
}
