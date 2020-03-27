package com.example.first;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)
        	return 0;
        int [][] dp = new int [s.length()][s.length()];
        
        int max = 0;
        for(int i=1;i<s.length();i++){
        	for(int j=0;j+i<s.length();j++){
        		if(s.charAt(j) == '(' && s.charAt(j+i) == ')'){
        			dp[j][j+i] = Math.min(dp[j+1][j+i], dp[j][j+i-1]) + 2;
        		}else{
        			dp[j][j+i] = Math.max(dp[j+1][j+i], dp[j][j+i-1]);
        		}
        		if(i+1 == dp[j][j+i] && dp[j][j+i] > max){
        			max = dp[j][j+i];
        		}
        	}
        }
        return max;
    }
    
    public int longestValidParentheses2(String s){
    	if(s == null || s.length() == 0)
        	return 0;
        int [] dp = new int [s.length() + 1];
        char [] chars = s.toCharArray();
        int result = 0;
        for(int i=1;i<s.length();i++){
        	if(chars[i] == '(')
        		continue;
        	
        	if(i - dp[i] - 1 >= 0 && chars[i - dp[i] - 1] == '('){
        		dp[i+1] = dp[i - dp[i] - 1] +dp[i] + 2;
        	}
        	result = Math.max(result, dp[i+1]);
        }
        return result;
    }
}
