package com.example.first;

import java.util.HashSet;
import java.util.Set;

public class ValidSuduku {
	/**
	 * Testing the sukodu is valid or not
	 * @param board : given number array.
	 * @return
	 */
    public boolean isValidSudoku(char [][] board){
    	if(board == null || board.length !=9 || board[0].length != 9)
    		return false;
    	
    	for(int i=0;i<9;i++){
    		boolean [] map = new boolean[10];
    		for(int j=0;j<9;j++){
    			if(board[i][j] != '.'){
    				if(map[board[i][j] - '0']){
    					return false;
    				}
    				map[board[i][j] - '0'] = true;
    			}
    		}
    	}
    	
    	for(int i=0;i<9;i++){
    		boolean [] map = new boolean [10];
    		for(int j=0;j<9;j++){
    			if(board[j][i] != '.'){
    				if(map[board[j][i] - '0']){
    					return false;
    				}
    				map[board[j][i] - '0'] = true;
    			}
    		}
    	}
    	
    	for(int i=0;i<9;i++){
    		boolean [] map = new boolean [10];
    		for(int j=i/3*3;j<i/3*3+3;j++){
    			for(int k=i%3*3;k<i%3*3+3;k++){
    				if(board[j][k] != '.'){
        				if(map[board[j][k] - '0']){
        					return false;
        				}
        				map[board[j][k] - '0'] = true;
        			}
    			}
    		}
    	}
    	return true;
    }
}
