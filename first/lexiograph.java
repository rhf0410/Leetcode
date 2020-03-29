package com.example.first;

import java.beans.Visibility;
import java.util.ArrayList;
import java.util.Arrays;

public class lexiograph {
    public ArrayList<String> permutation(String str){
    	if(str == null)
    		return null;
    	ArrayList<String>results = new ArrayList<String>();
    	char [] chs = str.toCharArray();
    	boolean [] visit  = new boolean [chs.length];
    	for(int i=0;i<visit.length;i++){
    		visit[i] = false;
    	}
    	String result = new String("");
    	recursion(chs, 0, result, results);
    	return results;
    }
    
    private void recursion(char [] chs, int i, String result, ArrayList<String>results){
    	if(i == chs.length){
    		results.add(String.valueOf(chs));
    		return;
    	}
       	for(int j=i;j<chs.length;j++){
       		swap(chs, i, j);
       		recursion(chs, i+1,result, results);
       		swap(chs, i, j);
       	}
    }
    
    private void swap(char [] chs, int i, int j){
    	char ch =  chs[i];
    	chs[i] = chs[j];
    	chs[j] = ch;
    }
}
