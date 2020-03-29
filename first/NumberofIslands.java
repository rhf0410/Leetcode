package com.example.first;

public class NumberofIslands {
	private void changingGrid(char[][] grid, int i, int j){
		if(i<0 || i>=grid.length)
			return;
		if(j<0 || j>=grid[i].length)
			return;
		if(grid[i][j] == '0')
			return;
		if(grid[i][j] == '1'){
			grid[i][j] = '0';
			changingGrid(grid, i, j+1);
			changingGrid(grid, i+1, j);
			changingGrid(grid, i, j-1);
			changingGrid(grid, i-1, j);
		}
	}
	
	/**
	 * Find the number of islands
	 * @param grid:the whole map
	 * @return the number of islands
	 */
    public int numIslands(char[][] grid) {
    	if(grid == null)
    		return 0;
        int num = 0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[i].length;j++){
        		if(grid[i][j] == '1'){
        			num++;
        			changingGrid(grid, i, j);
        		}
        	}
        }
        return num;
    }
}
