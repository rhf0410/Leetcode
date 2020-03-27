package com.example.second;

public class Leetcode402 {
	/**
	 * Remove K digits.
	 * @param num
	 * @param k
	 * @return
	 */
	public String removeKdigits(String num, int k) {
        String result = new String("");
		if(num == null || num.length() - k == 0)
        	return "0";
		int n = num.length() - k;
		String res = recursive(num, 0, n, result, Integer.MAX_VALUE);
		return res;
    }
	
	private String recursive(String num, int t, int n, String result, int min){
		if(result.length() == n){
			while(result.startsWith("0")){
				result = result.substring(1, result.length());
			}
			if(result.equals(""))
				result = "0";
			int Num = Integer.parseInt(result);
			if(Num < min)
				min = Num;
			return String.valueOf(min);
		}
		for(int i=t;i<num.length();i++){
			result += num.charAt(i);
			min = Integer.parseInt(recursive(num, i+1, n, result, min));
			result = result.substring(0, result.length() - 1);
		}
		return String.valueOf(min);
	}
}
