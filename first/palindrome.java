package com.example.first;

import java.util.ArrayList;
import java.util.List;

public class palindrome {
	public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0)
        	return null;
        List<List<String>>[] results = new List[s.length() + 1];
        boolean [][] dp = new boolean [s.length()][s.length()];
        results[0] = new ArrayList<List<String>>();
        results[0].add(new ArrayList<String>());
        
        for(int i=0;i<s.length();i++){
        	results[i+1] = new ArrayList<List<String>>();
        	for(int j=0;j<=i;j++){
        		if(s.charAt(j) == s.charAt(i) && (i - j <= 1 || dp[j+1][i-1])){
        			dp[j][i] = true;
        			String ref = s.substring(j, i+1);
        			for(List<String>r : results[j]){
        				List<String>ri = new ArrayList<String>(r);
        				ri.add(ref);
        				results[i+1].add(ri);
        			}
        		}
        	}
        }
        return results[s.length()];
    }
}
