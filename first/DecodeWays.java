package com.example.first;

public class DecodeWays {
	/**
	 * Decoding the number
	 * @param s:given string
	 * @return
	 */
	public int numDecodings(String s) {
        if(s==null || s.length() == 0 || (s.length() >= 1 && s.charAt(0) == '0')){
        	return 0;
        }
        int n = s.length();
        int [] dp = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<n+1;i++){
        	if(s.charAt(i-1) != '0')
        		dp[i] += dp[i-1];
        	if(isValid(s.substring(i-2,i))){
        		dp[i] += dp[i-2];
        	}
        	if(dp[i] == 0)
        		return 0;
        }
        return dp[n];
    }
	
	private boolean isValid(String s){
		if(s.charAt(0) == '0')
			return false;
		if(s.charAt(0) > '2' || (s.charAt(0) == '2' && s.charAt(1) > '6'))
			return false;
		return true;
	}
}
