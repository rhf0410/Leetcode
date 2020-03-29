package com.example.first;

public class SudokuSolver {
	boolean [][] rows = new boolean[9][10];
	boolean [][] cols = new boolean[9][10];
	boolean [][] insection = new boolean[9][10];
	
	/**
	 * Sudoku Solver
	 * @param board:given number
	 */
    public void solveSudoku(char[][] board) {
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			if(board[i][j] != '.'){
    				int n = board[i][j] - '0';
    				int nx = i/3;
    				int ny = j/3;
    				rows[i][n] = true;
    				cols[j][n] = true;
    				insection[ny*3+nx][n] = true;
    			}
    		}
    	}
    	fill(board, 0, 0);
    }
    
    /**
     * Fill data
     * @param board
     * @param x
     * @param y
     * @return
     */
    private boolean fill(char[][] board, int x, int y){
    	if(y == 9)
    		return true;
    	
    	int nx = (x+1)%9;
    	int ny = (nx == 0) ? y+1 : y;
    	
    	if(board[x][y] != '.')
    		return fill(board, nx, ny);
    	
    	for(int i=1;i<10;i++){
    		int bx = x/3;
    		int by = y/3;
    		int t = by*3 + bx;
            if(!(rows[x][i] || cols[y][i] || insection[t][i])){
            	rows[x][i] = true;
        		cols[y][i] = true;
        		insection[t][i] = true;
        		board[x][y] = String.valueOf(i).charAt(0);
        		if(fill(board, nx, ny))
        		    return true;
        		rows[x][i] = false;
        		cols[y][i] = false;
        		insection[t][i] = false;
        		board[x][y] = '.';
            }
    	}
    	return false;
    }
    
    /**
     * fill data
     * @param board
     * @param nums
     * @param x
     * @param y
     *//*
    private void fillNumber(char[][] board, ArrayList<Integer>nums, int x, int y){
    	//X axis
    	for(int i=0;i<9 && i != y;i++){
    		if(board[x][i] != '.'){
    			if(nums.contains(board[x][i] - '0')){
    				nums.remove(board[x][i] - '0');
    			}
    		}
    	}
    	
    	//Y axis
    	for(int i=0;i<9 && i != x;i++){
    		if(board[i][y] != '.'){
    			if(nums.contains(board[i][y] - '0')){
    				nums.remove(board[i][y] - '0');
    			}
    		}
    	}
    	
    	//9 mazes
    	for(int i=(x/3)*3;i<(x/3)*+3 && i != y;i++){
    		for(int j=(y/3)*3;j<(y/3)*3+3 && j != x;j++){
    			if(board[i][j] != '.'){
    				if(nums.contains(board[i][j] - '0')){
    					nums.remove(board[i][j] - '0');
    				}
    			}
    		}
    	}
    	
    	//fill data
    	if(nums.size() == 1){
    		board[x][y] = (char) (nums.get(0) + '0');
    		nums.clear();
    		for(int i=1;i<10 && i != y;i++){
    			if(nums.contains(board[x][i] - '0')){
    				nums.remove(board[x][i] - '0');
    			}
        	}
    	}
    }*/
}
