package com.example.first;

public class DecodeWaysII {
	/**
	 * Decoding ways
	 * @param s:given string
	 * @return
	 */
	public int numDecodings(String s) {
        if(s == null || s.length() == 0)
        	return 0;
        int m = 1000000007;
        int n = s.length();
        long c1 = 1;
        long c2 = isValidorNot(s.substring(0,1));
        for(int i=1;i<n;i++){
        	long temp = (c2 * isValidorNot(s.substring(i,i+1))) + (c1 * isValidorNot(s.substring(i-1,i+1)));
        	c1 = c2;
        	c2 = temp % m;
        }
        return (int)c2;
    }
	
	/**
	 * Find the number of all possible strings
	 * @param s:given string
	 * @return
	 */
	private int isValidorNot(String s){
		if(s.length() == 1){
			if(s.charAt(0) == '*')
				return 9;
			return s.charAt(0) == '0' ? 0 : 1;
		}
		else{
			if(s.charAt(0) == '*'){
				if(s.charAt(1) == '*'){
					return 15;
				}else{
					return s.charAt(1) <= '6' && s.charAt(1) >= '0' ? 2 : 1;
				}
			}else{
				if(s.charAt(1) == '*'){
					if(s.charAt(0) == '2'){
						return 6;
					}
					if(s.charAt(0) == '1'){
						return 9;
					}
					return 0;
				}
			}
		}
		int num = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
		return num >= 10 && num <= 26 ? 1 : 0;
	}
}
