package com.example.second;

public class Leetcode530 {
	/**
	 * Friend circles.
	 * @param M
	 * @return
	 */
	public int findCircleNum(int[][] M) {
        int result = 0;
        if(M == null || M.length == 0){
        	return result;
        }
        boolean [] visit = new boolean[M.length];
        for(int i=0;i<M.length;i++){
        	if(!visit[i]){
        		result++;
        		dfs(M, visit, i);
        	}
        }
        return result;
    }
	
	/**
	 * Backtracking.
	 * @param M
	 * @param visit
	 * @param x
	 * @param y
	 */
	private void dfs(int [][]M, boolean[] visit, int x){
		for(int i=0;i<M.length;i++){
			if(M[x][i] == 1 && !visit[i]){
				visit[i] = true;
				dfs(M,visit,i);
			}
		}
	}
}
