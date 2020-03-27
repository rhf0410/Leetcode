package com.example.first;

public class SurroundedRegions {
	/**
	 * Output the board again.
	 * @param board
	 */
    public void solve(char[][] board) {
    	if(board == null || board.length == 0 || board[0].length == 0)
            return;
    	int n = board.length;
    	int m = board[0].length;
    	boolean [][] visited = new boolean [n][m];
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[i].length;j++){
        		if(board[i][j] == 'O'&&!visited[i][j]){
        			recursion(board, i, j, visited);
        		}
        	}
        }
    }
    
    /**
     * Resursion operation
     * @param board:given board
     * @param x:axis x
     * @param y:axis y
     */
    private boolean recursion(char[][] board, int x, int y, boolean [][] visited){
    	boolean flag1 = false;
    	if((x+1>=board.length || x-1 <0 || y+1 >= board[0].length || y-1 < 0)&&board[x][y] == 'O')
    		return true;
    	if(board[x][y] == 'O'){
    		board[x][y] = 'X';
    		flag1 = recursion(board, x, y+1, visited)||recursion(board, x+1, y, visited)||recursion(board, x, y-1, visited)||recursion(board, x-1, y, visited);
    	}
    	if(flag1){
    		board[x][y] = 'O';
    		visited[x][y] = true;
    	}
    	return flag1;
    }
    
    /**
     * Find the greatest common decimal
     * @param m:first number
     * @param n:second number
     * @return
     */
    public int gcd(int m, int n){
    	if(m == n)
    		return m;
    	if(m>n){
    		return gcd(m-n, n);
    	}else{
    		return gcd(n-m,m);
    	}
    }
}
