package com.example.second;

import java.util.ArrayList;
import java.util.List;

public class Leetcode916 {
	/**
	 * Word Subsets.
	 * @param A
	 * @param B
	 * @return
	 */
	public List<String> wordSubsets(String[] A, String[] B) {
        List<String>res = new ArrayList<String>();
        if(A == null || A.length == 0)
        	return res;
        int [] tableB = new int [26];
        for(int i=0;i<B.length;i++){
        	int [] table = this.buildTable(B[i]);
        	for(int j=0;j<table.length;j++){
        		tableB[j] = Math.max(tableB[j], table[j]);
        	}
        }
        for(int i=0;i<A.length;i++){
        	int [] tableA = this.buildTable(A[i]);
        	int j=0;
        	for(;j<26;j++){
        		if(tableA[j] < tableB[j])
        			break;
        	}
        	if(j == 26)
        		res.add(A[i]);
        }
        return res;
    }
	
	private int [] buildTable(String str){
		int [] table = new int [26];
		for(int i=0;i<str.length();i++){
			table[str.charAt(i) - 'a']++;
		}
		return table;
	}
}
