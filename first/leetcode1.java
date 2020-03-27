package com.example.first;

public class leetcode1 {
    /**
     * the largest palindromic 
     * @param str:given string
     * @return the amount of the largest palindromic 
     */
	public String theLargestPalindromic(String str){
		if(str == null || str.length() == 0)
			return null;
		/*if(isPalindromic(str, 0, str.length() - 1))
			return str;*/
		
		int max = 0;
		int start = 0;
		int end = 0;
		int [][] dp = new int [str.length()][str.length()];
		for(int i=0;i<str.length();i++){
			dp[i][i] = 1;
		}
		
		for(int i=1;i<str.length();i++){
			for(int j=0;j+i<str.length();j++){
				if(str.charAt(j) == str.charAt(j+i)){
					if(i == 1)
						dp[j][j+i] = 2;
					else
					    dp[j][j+i] = dp[j+1][j+i-1] > 0 ? dp[j+1][j+i-1] + 2 : 0;
					if(dp[j][j+i] > max){
						max = dp[j][j+i];
						start = j;
						end = j+i;
					}
				}
			}
		}
		
		return str.substring(start, end + 1);
	}
	
	/**
	 * palindromic
	 */
	public boolean isPalindromic(String str,int begin,int end){
		if(begin == end)
			return true;
		if(str.charAt(begin) == str.charAt(end)){
			begin++;
			end--;
			if(begin > end)
				return true;
			return true && isPalindromic(str, begin, end);
		}else
			return false;
	}
}
