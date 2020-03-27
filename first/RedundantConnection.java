package com.example.first;

import java.util.HashSet;
import java.util.Set;

public class RedundantConnection {
	/**
	 * Find redundant edge
	 * @param edges:given edges
	 * @return redundant edge
	 */
    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null)
        	return null;
        int s = 2001;
        int [] begin = new int [s];
        for(int i=0;i<s;i++){
        	begin[i] = i;
        }
        int [] result = new int [2];
        result[0] = edges[0][0];
        result[1] = edges[0][1];
        for(int i=0;i<edges.length;i++){
        	int x = edges[i][0];
        	int y = edges[i][1];
        	
        	if(begin[x] == begin[y]){
        		result[0] = x;
        		result[1] = y;
        		return result;
        	}
        	int ref = begin[y];
        	for(int j=0;j<s;j++){
        		if(begin[j] == ref){
        			begin[j] = begin[x];
        		}
        	}
        }
        return result;
    }
    
    /**
     * Find the number of union set.
     * @param edges:given edges
     * @return:the number of union set
     */
    public int findunionset(int[][] edges){
    	int n = 2001;
    	int [] begin = new int[n];
    	for(int i=0;i<n;i++){
    		begin[i] = i;
    	}
    	for(int i=0;i<edges.length;i++){
    		int x = edges[i][0];
    		int y = edges[i][1];
    		int value = begin[y];
    		for(int j=0;j<n;j++){
    			if(begin[j] == value){
    				begin[j] = begin[x];
    			}
    		}
    	}
    	Set<Integer> set = new HashSet<Integer>();
    	for(int i=0;i<edges.length;i++){
    		set.add(begin[edges[i][0]]);
    		set.add(begin[edges[i][1]]);
    	}
    	return set.size();
    }
    
    /**
     * Union and find
     * @param edges:given edges
     * @return
     */
    public void unionfind(int [][] edges, int n){
    	int [] s = new int [n];
    	for(int i=0;i<n;i++){
    		s[i] = -1;
    	}
    	for(int i=0;i<edges.length;i++){
    		int x = edges[i][0];
    		int y = edges[i][1];
    		operatingUnionFind(s, x, y);
    	}
    	for(int i=0;i<n;i++)
    		System.out.println(":"+s[i]);
    }
    
    public void operatingUnionFind(int [] s,int root1, int root2){
    	if(find(s,root1) == find(s,root2))
    		return;
    	
    	if(s[root1] < s[root2]){
    		s[root2] = root1;
    	}else{
    		if(s[root1] == s[root2])
    			s[root1]--;
    		s[root1] = root2;
    	}
    }
    
    public int find(int [] s, int root){
    	if(s[root] < 0)
    		return root;
    	return s[root] = find(s,s[root]);
    } 
}
