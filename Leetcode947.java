package com.example.second;

public class Leetcode947 {
	/**
	 * Most stones removed with same row or column.
	 * @param stones
	 * @return
	 */
	public int removeStones(int[][] stones) {
        if(stones == null || stones.length == 0){
        	return 0;
        }
        int max = 0;
        int [] f = new int[stones.length + 1];
        for(int i=0;i<stones.length;i++){
        	f[i] = i;
        }
        for(int i=0;i<stones.length;i++){
        	for(int j=i+1;j<stones.length;j++){
        		if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
        			int fu = getf(f, i);
        			int vu = getf(f, j);
        			if(fu != vu)
        				union(f, fu, vu);
        		}
        	}
        }
        int num = 0;
        for(int i=0;i<stones.length;i++){
        	if(f[i] == i){
        		num++;
        	}
        }
        return stones.length - num;
    }
	
	public int getf(int []f, int u){
		if(f[u] == u){
			return u;
		}else{
			f[u] = getf(f,f[u]);
			return f[u];
		}
	}
	
	public void union(int [] f, int u, int v){
		f[u] = v;
	}
}
