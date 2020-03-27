package com.example.second;

public class Leetcode959 {
	/**
	 * Regions cut by slashes.
	 * @param grid
	 * @return
	 */
	public int regionsBySlashes(String[] grid) {
        if(grid == null || grid.length == 0){
        	return 0;
        }
        int [][] new_grid = new int[grid[0].length() * 3][grid.length * 3];
        boolean [][] visit = new boolean[grid[0].length() * 3][grid.length * 3];
        
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[i].length();j++){
        		if(grid[i].charAt(j) == '/'){
        			new_grid[3*i][3*j+2] = new_grid[3*i + 1][3*j+ 1] = new_grid[3*i + 2][3*j] = 1;
        		}else if(grid[i].charAt(j) == '\\'){
        			new_grid[3*i][3*j] = new_grid[3*i + 1][3*j+ 1] = new_grid[3*i + 2][3*j + 2] = 1;
        		}
        	}
        }
        
        int [][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        int res = 0;
        for(int i=0;i<new_grid.length;i++){
        	for(int j=0;j<new_grid[i].length;j++){
        		if(visit[i][j] || new_grid[i][j] == 1){
        			continue;
        		}
        		
        	}
        }
        
        return res;
    }
}
