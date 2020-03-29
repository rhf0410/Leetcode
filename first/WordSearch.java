package com.example.first;

public class WordSearch {
	private int [][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
	/**
	 * Word Search.
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
        if(board == null || word == null)
        	return false;
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j] == word.charAt(0)){
        			boolean [][] visit = new boolean [board.length][board[0].length];
        			visit[i][j] = true;
        			boolean flag = recursive(board, word, i, j, 0, visit);
        			if(flag)
        				return true;
        		}
        	}
        }
        return false;
    }
	
	private boolean recursive(char[][] board, String word, int loc1, int loc2, int loc, boolean [][] visit){
		if(loc == word.length() - 1){
			return true;
		}
		boolean flag = false;
		for(int i=0;i<directions.length;i++){
			int new_loc1 = loc1 + directions[i][0];
			int new_loc2 = loc2 + directions[i][1];
			if(new_loc1 >= 0 && new_loc1 < board.length 
					&& new_loc2 >= 0 && new_loc2 < board[0].length 
					&& word.charAt(loc + 1) == board[new_loc1][new_loc2] && !visit[new_loc1][new_loc2]){
				visit[new_loc1][new_loc2] = true;
				flag = flag || recursive(board, word, new_loc1, new_loc2, loc + 1, visit);
				visit[new_loc1][new_loc2] = false;
			}
		}
		return flag || false;
	}
}
